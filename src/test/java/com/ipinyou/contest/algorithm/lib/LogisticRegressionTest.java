package com.ipinyou.contest.algorithm.lib;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import weka.classifiers.functions.Logistic;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

/**
 * User: yguan
 * Date: 11/3/13
 * Time: 11:46 AM
 */
public class LogisticRegressionTest {
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {

    }

    @Test
    public void testRegression() throws Exception {


        Attribute sLength = new Attribute("sLength");
        Attribute sWidth = new Attribute("sWidth");
        Attribute pLength = new Attribute("pLength");
        Attribute pWidth = new Attribute("pWidth");
        Attribute label = new Attribute("label");

        FastVector attributes = new FastVector(5);
        attributes.addElement(sLength);
        attributes.addElement(sWidth);
        attributes.addElement(pLength);
        attributes.addElement(pWidth);
        attributes.addElement(label);

        Instances instances = new Instances("test", attributes, 5);

        Instance instance = new Instance(5);
        instance.setValue(sLength, 5.1);
        instance.setValue(sWidth, 3.5);
        instance.setValue(pLength, 1.4);
        instance.setValue(pWidth, 0.2);
        instance.setValue(label, 0);
        instances.add(instance);

        instance = new Instance(5);
        instance.setValue(sLength, 4.9);
        instance.setValue(sWidth, 3.0);
        instance.setValue(pLength, 1.4);
        instance.setValue(pWidth, 0.2);
        instance.setValue(label, 0);
        instances.add(instance);

        instance = new Instance(5);
        instance.setValue(sLength, 4.7);
        instance.setValue(sWidth, 3.2);
        instance.setValue(pLength, 1.3);
        instance.setValue(pWidth, 0.2);
        instance.setValue(label, 0);
        instances.add(instance);

        instance = new Instance(5);
        instance.setValue(sLength, 7.0);
        instance.setValue(sWidth, 3.2);
        instance.setValue(pLength, 4.7);
        instance.setValue(pWidth, 1.4);
        instance.setValue(label, 1);
        instances.add(instance);

        instance = new Instance(5);
        instance.setValue(sLength, 6.4);
        instance.setValue(sWidth, 3.2);
        instance.setValue(pLength, 4.5);
        instance.setValue(pWidth, 1.5);
        instance.setValue(label, 1);
        instances.add(instance);

        System.err.println(instances.toString());

        instances.setClassIndex(instances.numAttributes() - 1);
//        weka.classifiers.functions.LogisticRegression regression = new weka.classifiers.functions.LogisticRegression();
        NumericToNominal filter = new NumericToNominal();
        filter.setInputFormat(instances);
        filter.setAttributeIndices("5");
        instances = Filter.useFilter(instances, filter);
        Logistic regression = new Logistic();
        regression.buildClassifier(instances);

        Instance testInstance = new Instance(5);
        testInstance.setValue(sLength, 6.4);
        testInstance.setValue(sWidth, 3.2);
        testInstance.setValue(pLength, 4.5);
        testInstance.setValue(pWidth, 1.5);
        //instance.setValue(label, 1);
        testInstance.setDataset(instances);


        double result = regression.classifyInstance(testInstance);

        System.err.println(result);


    }
}
