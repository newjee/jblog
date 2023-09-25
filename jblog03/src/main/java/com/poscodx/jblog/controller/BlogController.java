package com.poscodx.jblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller

@RequestMapping("/{id}")
public class BlogController {

	@ResponseBody
	@RequestMapping({"", "/{categoryNo}", "/{categoryNo}/{postNo}" })
	public String index(
            @PathVariable("id") String blogId,
            @PathVariable("categoryNo") Optional<Long> categoryNo,
            @PathVariable("postNo") Optional <Long> postNo) {

		return "BlogController.index()";
//		return "blog/main";

	}

	@ResponseBody
	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String blogId) {
		return "BlogController.adminBasic()";
	}

}
