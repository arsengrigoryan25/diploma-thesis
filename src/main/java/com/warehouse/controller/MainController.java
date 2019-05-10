package com.warehouse.controller;

import com.warehouse.domain.dto.InfoDTO;
import com.warehouse.domain.dto.ProductDTOView;
import com.warehouse.domain.entity.InfoEntity;
import com.warehouse.domain.entity.ProductEntity;
import com.warehouse.domain.filter.ProductFilter;
import com.warehouse.domain.filter.ProductInfoFilter;
import com.warehouse.repository.InfoRepository;
import com.warehouse.repository.ProductRepository;
import com.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private InfoRepository infoRepository;

    private static final String TIME_PATTERN = "";

    @RequestMapping("/")
    public String main() {
        return "main";
    }

    @RequestMapping("/searchHistoryPage")
    public ModelAndView searchHistoryPage() {
        ModelAndView modelAndView = new ModelAndView("searchHistory");
        return modelAndView;
    }

    @RequestMapping("/searchHistory")
    public ModelAndView searchHistoryByDate(@RequestParam String barcode,
                                            @RequestParam String startDateString,
                                            @RequestParam String endDateString
    ) {
        ModelAndView modelAndView = new ModelAndView("searchHistory");

        Date startDate = null;
        Date endDate = null;

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAfterReg = null;
        Date dateBeforeReg = null;



        try {
            if (!"".equals(startDateString)) {
                dateAfterReg = format.parse(startDateString);
            }
            if (!"".equals(endDateString)) {
                dateBeforeReg = format.parse(endDateString);
            }

//            if (!startDateString.trim().isEmpty()) {
////                startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateString);
//
//                Calendar mydate = new GregorianCalendar();
//                Date thedate = null;
//                try {
//                    thedate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(startDateString);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                mydate.setTime(thedate);
//
//                int y = mydate.get(Calendar.YEAR);
//                int mo = mydate.get(Calendar.MONTH);
//                int dm = mydate.get(Calendar.DAY_OF_MONTH);
//                int dw = mydate.get(Calendar.DAY_OF_WEEK);
//                int h = mydate.get(Calendar.HOUR);
//                int m = mydate.get(Calendar.MINUTE);
//                int s = mydate.get(Calendar.SECOND);
//                int mil = mydate.get(Calendar.MILLISECOND);
//                int ap = mydate.get(Calendar.AM_PM);
//                int hd = mydate.get(Calendar.HOUR_OF_DAY);
//
//                startDate = new Date(y,mo,dm);
//            }
//            if (!endDateString.trim().isEmpty()) {
////                endDate = new SimpleDateFormat("YYYY-MM-DD").parse(endDateString);
//
//                Calendar mydate = new GregorianCalendar();
//                Date thedate = null;
//                try {
//                    thedate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(endDateString);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                mydate.setTime(thedate);
//
//                int y = mydate.get(Calendar.YEAR);
//                int mo = mydate.get(Calendar.MONTH);
//                int dm = mydate.get(Calendar.DAY_OF_MONTH);
//                int dw = mydate.get(Calendar.DAY_OF_WEEK);
//                int h = mydate.get(Calendar.HOUR);
//                int m = mydate.get(Calendar.MINUTE);
//                int s = mydate.get(Calendar.SECOND);
//                int mil = mydate.get(Calendar.MILLISECOND);
//                int ap = mydate.get(Calendar.AM_PM);
//                int hd = mydate.get(Calendar.HOUR_OF_DAY);
//
//                endDate = new Date(y,mo,dm);
//            }
        } catch (ParseException e) {
            e.printStackTrace();
            modelAndView.addObject("error", "Արժեքները սխալ է լրացված");
            return modelAndView;
        }
        List<InfoDTO> infoDTOList = productService.getProductInfo(new ProductInfoFilter(barcode, startDate, endDate));
        modelAndView.addObject("searchInfo", infoDTOList);
        return modelAndView;
    }

    @RequestMapping("/sellProductPage")
    public ModelAndView sellProductPage() {
        ModelAndView modelAndView = new ModelAndView("sellProduct");
        return modelAndView;
    }

    @RequestMapping("/searchProductByBarcode")
    public ModelAndView searchProductByBarcode(@RequestParam String barcode
    ) {
        ModelAndView modelAndView = new ModelAndView("sellProduct");
        ProductEntity productEntity = productRepository.findByBarcode(barcode);

        modelAndView.addObject("productEntity", productEntity);
        return modelAndView;
    }

    @RequestMapping("/sellProduct")
    public ModelAndView sellProduct(@RequestParam String barcode,
                                    @RequestParam String count
    ) {
        int countOfSell;
        int countOfSellInDB;
        int countInShop;
        if (!count.trim().isEmpty()) {
            countOfSell = new Integer(count);
            productService.updateProductsSell(new ProductDTOView("", barcode, 0, 0, countOfSell));

            countOfSellInDB = productService.getCountProductOfSellByBarcode(barcode);
            infoRepository.save(new InfoEntity(new Date(), barcode, true, 0, 0, countOfSell, countOfSellInDB,
                    "Vacharvel e " + countOfSell + " hat apranq, vori  shtrix code - " + barcode));

            countInShop = productService.getCountProductInShopByBarcode(barcode);
            infoRepository.save(new InfoEntity(new Date(), barcode, false, 0, countOfSell, 0, countInShop,
                    "Hanvel e xanutic " + countOfSell + " hat apranq, vori  shtrix code - " + barcode));
        }

        return new ModelAndView("redirect:/sellProductPage");
    }


    /**
     * Returns Date value string format dd.MM.yy
     *
     * @param stringDate
     * @return
     */
    public static Date stringToDate(String stringDate) throws ParseException {
        SimpleDateFormat format= new SimpleDateFormat("dd.MM.yyyy");
        return (stringDate != null ? format.parse(stringDate) : null);
    }
}

















