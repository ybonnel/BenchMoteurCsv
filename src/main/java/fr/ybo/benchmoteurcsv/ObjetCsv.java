package fr.ybo.benchmoteurcsv;

import fr.ybo.moteurcsv.adapter.AdapterBoolean;
import fr.ybo.moteurcsv.adapter.AdapterDouble;
import fr.ybo.moteurcsv.adapter.AdapterInteger;
import fr.ybo.moteurcsv.annotation.BaliseCsv;
import fr.ybo.moteurcsv.annotation.FichierCsv;

@FichierCsv
public class ObjetCsv {

	@BaliseCsv("a1")
	private String a1;
	@BaliseCsv(value = "a2", adapter = AdapterBoolean.class)
	private Boolean a2;
	@BaliseCsv(value = "a3", adapter = AdapterInteger.class)
	private Integer a3;
	@BaliseCsv(value = "a4", adapter = AdapterDouble.class)
	private Double a4;
	@BaliseCsv("a5")
	private String a5;
	@BaliseCsv("a6")
	private String a6;
	@BaliseCsv(value = "a7", adapter = AdapterBoolean.class)
	private Boolean a7;
	@BaliseCsv(value = "a8", adapter = AdapterInteger.class)
	private Integer a8;
	@BaliseCsv(value = "a9", adapter = AdapterDouble.class)
	private Double a9;
	@BaliseCsv("a10")
	private String a10;
	@BaliseCsv("a11")
	private String a11;
	@BaliseCsv(value = "a12", adapter = AdapterBoolean.class)
	private Boolean a12;
	@BaliseCsv(value = "a13", adapter = AdapterInteger.class)
	private Integer a13;
	@BaliseCsv(value = "a14", adapter = AdapterDouble.class)
	private Double a14;
	@BaliseCsv("a15")
	private String a15;
	@BaliseCsv("a16")
	private String a16;
	@BaliseCsv(value = "a17", adapter = AdapterBoolean.class)
	private Boolean a17;
	@BaliseCsv(value = "a18", adapter = AdapterInteger.class)
	private Integer a18;
	@BaliseCsv(value = "a19", adapter = AdapterDouble.class)
	private Double a19;
	@BaliseCsv("a20")
	private String a20;
}
