package org.example.morph.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/off")
@Controller
public class OffController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) { return "off/" + page; }
    @RequestMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) { return "off/" + page; }
}