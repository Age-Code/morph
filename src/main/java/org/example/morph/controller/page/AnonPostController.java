package org.example.morph.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/anon/post")
@Controller
public class AnonPostController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) { return "anon/post/" + page; }
    @RequestMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) { return "anon/post/" + page; }
}