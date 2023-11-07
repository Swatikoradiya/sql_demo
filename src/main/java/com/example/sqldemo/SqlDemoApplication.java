package com.example.sqldemo;

import com.example.sqldemo.designPatterns.adapter.SocketAdapter;
import com.example.sqldemo.designPatterns.adapter.SocketClassAdapter;
import com.example.sqldemo.designPatterns.adapter.SocketObjectAdapter;
import com.example.sqldemo.designPatterns.adapter.Volt;
import com.example.sqldemo.dsa.ArrayOperation;
import com.example.sqldemo.dsa.CountDigitInNumber;
import com.example.sqldemo.dsa.StringOperation;
import com.example.sqldemo.dsa.TwoSum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class SqlDemoApplication {

    public static void main(String[] args) {
        log.info("Loading spring boot project");

//		Scanner scanner = new Scanner(System.in);
//		log.info("Enter your input");
//
//		Scanner scanner1 = new Scanner(System.in);
//
//		log.info("Enter target string");
//		log.info("nth fibonacci number is : {}", CountDigitInNumber.countOccurrencesOfSubString(scanner.next(), scanner1.next()));

        //Design pattern....

        //Factory Pattern
		/*ProfessionFactory professionFactory = new ProfessionFactory();
		Profession profession = professionFactory.getProfession("Teacher");
		profession.print();

		//Abstract Factory
		AbstractFactory abstractFactory = AbstractFactoryProducer.getProfession(true);
		Profession profession1 = abstractFactory.getProfession("Teacher");
		profession1.print();

		//SingleTone
		SingleTone singleTone = SingleTone.getInstance();
		singleTone.simpleMethod();

		SingleTone singleTone1 = SingleTone.getInstance();
		singleTone1.simpleMethod();

		//ProtoType
		ProtoType protoType = new ProtoType(1,"ABC");
		System.out.println("protoType 1 : "+protoType);

		ProtoType protoType1 = protoType.clone();
		System.out.println("protoType 2 : "+protoType1);

		protoType1.setName("XYZ");

		ProtoType protoType2 = protoType1.clone();
		System.out.println("protoType 3 : "+protoType2);

		//Adapter Design Pattern
		testObjectAdapter();
		testClassAdapter();
*/
     /*   Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array : ");

        int[] array = new int[sc.nextInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        ArrayOperation.splitArray(array, sc.nextInt());*/
        SpringApplication.run(SqlDemoApplication.class, args);
    }

    private static void testObjectAdapter() {
        SocketAdapter socketAdapter = new SocketObjectAdapter();
        Volt volt = getAdapter(socketAdapter, 3);
        System.out.println("3 Volt with Object Adapter : " + volt.getVolts());
    }

    private static void testClassAdapter() {
        SocketAdapter socketAdapter = new SocketClassAdapter();
        Volt volt = getAdapter(socketAdapter, 3);
        System.out.println("3 Volt with class Adapter : " + volt.getVolts());
    }

    private static Volt getAdapter(SocketAdapter sockAdapter, int i) {
        switch (i) {
            case 3:
                return sockAdapter.get3Volt();
            case 12:
                return sockAdapter.get12Volt();
            default:
                return sockAdapter.get120Volt();
        }
    }

    public static List<List<Integer>> printArray(int[] array) {
        List<Integer> integer = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            integer.add(i);
        }


        List<List<Integer>> intList1 = new ArrayList<>();

        while (!integer.isEmpty()) {
            List<Integer> intList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (integer.get(i) != null) {
                    System.out.println(integer.get(i));
                    intList.add(array[i]);
                    integer.remove(i);
                }

            }

            intList1.add(intList);
        }

        return intList1;
    }

    public static void consumerExample(List<String> stringList) {
        Consumer<String> consumer = System.out::println;
        stringList.forEach(consumer);
    }
}
