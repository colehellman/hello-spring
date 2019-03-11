package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {


    @RequestMapping(value="")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "goodbye";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select id='language' name='language'><option value=''>Pick a language</option><option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='chinese'>Chinese</option>" +
                "<option value='korean'>Korean</option>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";
        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        if (language.equals("french")) {
            return "Bonjour " + name;
        }
        if (language.equals("spanish")) {
            return "Hola " + name;
        }
        if (language.equals("german")) {
            return "Hallo " + name;
        }
        if (language.equals("chinese")) {
            return "Ni hao " + name;
        }
        else {
            return "Yeoboseyo " + name;
        }
    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

}
