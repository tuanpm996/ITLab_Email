import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		long start = System.currentTimeMillis();
		ExecutorService pool = Executors.newFixedThreadPool(5000);

		FileReader in = new FileReader("src/107983_aariclist_25k.csv");
		BufferedReader br = new BufferedReader(in);

		String csvSplitBy = ",";
		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			String[] elements = line.split(csvSplitBy);
			Thread thread = new Thread(new Email(i, elements[0].replace("\"", "")));
			pool.execute(thread);
			i++;
		}
		br.close();
		pool.shutdown();
		while (!pool.isTerminated()) {
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " miliseconds");

	}

}
