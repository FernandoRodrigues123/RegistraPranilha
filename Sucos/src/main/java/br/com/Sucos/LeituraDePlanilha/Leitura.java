package br.com.Sucos.LeituraDePlanilha;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.Sucos.Modulo.Produto;
import lombok.Cleanup;

public class Leitura {

	public List<Produto> criar() throws IOException {
		List<Produto> listProduto = new ArrayList<Produto>();

		@Cleanup
		FileInputStream file = new FileInputStream("PRODUTOS.xlsx");
		Workbook workbook = new XSSFWorkbook(file);

		Sheet sheetAt = workbook.getSheetAt(0);

		List<Row> rows = (List<Row>) toList(sheetAt.iterator());
		rows.remove(0);

		rows.forEach(row ->{
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());

			Double codigoProduto = cells.get(0).getNumericCellValue();
			String descricao = cells.get(1).getStringCellValue();
			String embalagem = cells.get(2).getStringCellValue();
			double preco = cells.get(3).getNumericCellValue();

			String codigoProdutoString = String.valueOf(codigoProduto);
			Produto produto = new Produto(codigoProdutoString, descricao, embalagem, preco);
			listProduto.add(produto);

		});

		return listProduto;

	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);

	}

}
