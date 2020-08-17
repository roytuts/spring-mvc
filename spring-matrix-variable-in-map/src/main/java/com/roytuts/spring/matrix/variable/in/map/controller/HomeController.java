package com.roytuts.spring.matrix.variable.in.map.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping("/owner/{ownerId}/report/{reportId}")
	public String homePage(@PathVariable String ownerId, @MatrixVariable Map<String, List<String>> matrixVars,
			@MatrixVariable(pathVar = "reportId") Map<String, List<String>> reportMatrixVars, Model model) {
		System.out.println("ownerId : " + ownerId);

		List<List<String>> matrixVarlist = mapToList(matrixVars);
		for (List<String> list : matrixVarlist) {
			for (String string : list) {
				System.out.println(string);
			}
		}

		List<List<String>> reportMatrixVarlist = mapToList(matrixVars);

		for (List<String> list : reportMatrixVarlist) {
			for (String string : list) {
				System.out.println(string);
			}
		}

		model.addAttribute("matrixVars", matrixVars);
		model.addAttribute("reportMatrixVars", reportMatrixVars);

		return "index";
	}

	private List<List<String>> mapToList(Map<String, List<String>> matrixVarMap) {
		List<List<String>> outlist = new ArrayList<List<String>>();
		Collection<Entry<String, List<String>>> matrixVarSet = matrixVarMap.entrySet();

		for (Entry<String, List<String>> entry : matrixVarSet) {
			List<String> rowList = new ArrayList<String>();

			String name = entry.getKey();
			rowList.add(name);

			List<String> matrixVar = entry.getValue();
			rowList.addAll(matrixVar);

			outlist.add(rowList);
		}
		return outlist;
	}

}
