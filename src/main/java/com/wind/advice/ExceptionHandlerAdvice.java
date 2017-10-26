package com.wind.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lilandong
 * @date 2017/10/25
 * @desc 建言，全局配置。针对于所有@Controller类中的方法
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {
    /**
     * 用于全局处理控制器里的异常
     * value 拦截条件，此处拦截所有异常
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("error");// error页面
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }

    /**
     * 绑定键值对到model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "额外信息"); //3
    }

    /**
     * 设置WebDataBinder,WebDataBinder用来自动绑定前台请求参数到model中
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        //演示忽略request参数中的sex
        webDataBinder.setDisallowedFields("sex");
    }
}
