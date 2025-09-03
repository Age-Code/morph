package org.example.morph.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/anon")
@Controller
public class AnonController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) { return "anon/" + page; }
    @RequestMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable String id) { return "anon/" + page; }
}