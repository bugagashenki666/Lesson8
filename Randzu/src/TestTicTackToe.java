public class TestTicTackToe {//Использовать только для тестирования отдельных функций, для запуска использовать
    //требуемые функции предварительно сделав их public
    public static void main(String[] args) {
        Field field = new Field(5, 10, 10);
        field.initTest();
        field.printField();
        //System.out.println(field.checkHorizontal(6, 0, Field.X));
        //System.out.println(field.checkVertical(0, 9,Field.O));
        //System.out.println(field.checkLeftDiagonal(6,6, Field.X));
        //System.out.println(field.checkRightDiagonal(9,0, Field.O));
    }
}
