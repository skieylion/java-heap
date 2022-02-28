module demomodule2 {
    requires demomodule1;

    provides module1.calc.Calculator with module2.CalculatorImpl2;
}