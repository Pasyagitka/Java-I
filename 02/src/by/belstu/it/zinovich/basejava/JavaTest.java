package by.belstu.it.zinovich.basejava;


/**d)Выполнить статический импорт*/
//import static java.lang.Math.log;
import static  java.lang.Math.*;


/**@author pasyagitka @version 0.1 */
public class JavaTest {
    //final - начения постоянны и не могут быть изменены
    //static
    final int const1 = 0;
    /**c)Задать константы в классе*/
    public final int const2 = 0;
    public static final int const3 = 0;
    static int sint;


    /**main
     * @return void
     * @throws
     * @param args
     * */
    public static void main(String[] args) {
        /**b)*/
        char charvar = 'c';
        int intvar = 57;
        /**shortvar variable
         * @value 12
         * @see <a href="scope.html">Search</a>
         * */
        short shortvar = 12;
        byte bytevar = 9;
        long longvar = 389843;
        boolean booleanvar = false;
        String stringvar = "efwejfief";
        double doublevar = 328.3;
        System.out.println(stringvar+intvar); //конкатенация
        System.out.println(stringvar+charvar); //конкатенация
        System.out.println(stringvar+doublevar); //конкатенация
        bytevar = (byte) (bytevar + intvar);
        intvar = (int) (doublevar + longvar);
        longvar = (long)intvar + 2147483647; //при выводе значение должно быть положительное
        System.out.println(longvar);
        System.out.println(sint);
        booleanvar = booleanvar && true;
        booleanvar = booleanvar ^ true;
        //booleanvar = booleanvar + true; нельзя
        var findtype1 = 9223372036854775807l;
        var findtype2 = 0x7fff_ffff_fffl;
        char charvar1 = 'a';
        System.out.println(charvar1); //a
        char charvar2 = '\u0061';
        System.out.println(charvar2); //a
        char charvar3 = 97;
        System.out.println(charvar3); //a
        System.out.println(charvar1+charvar2+charvar3); //291
        System.out.println(3.45%2.4); //1.0500000000000003
        System.out.println(1.0/0.0); //Infinity
        System.out.println(0.0/0.0);    //NaN
        System.out.println(log(-345));  //NaN
        System.out.println(Float.intBitsToFloat(0x7F800000)); //Infinity
        System.out.println(Float.intBitsToFloat(0xFF800000)); //-Infinity

        /**d)Вывести значения, вывести случайное число*/
        System.out.println(PI);    //3.141592653589793
        System.out.println(E);      //2.718281828459045
        System.out.println(round(PI)); //3
        System.out.println(round(E));    //3
        System.out.println(min(PI, E)); //2.718281828459045
        System.out.println(random()); //[0;1)


        /**e)Создание объектов разных классов оболочек*/
        Boolean booleanobject = false;
        Character characterobject = 'f';
        Integer integerobj = 12;
        Byte byteobj = 1;
        Short shortobj = 12;
        Long longobj = 111L;
        Double doubleobj = 1.2;
        System.out.println(integerobj <<2);//48
        System.out.println(integerobj>>>2);//3
        System.out.println(characterobject + 'l');//210
        System.out.println(booleanobject & false);//false
        System.out.println(Long.MIN_VALUE +"\t"+Long.MAX_VALUE);
        System.out.println(Double.MIN_VALUE +"\t"+Double.MAX_VALUE);
        Integer boxing = intvar; //упаковка распаковка
        int a = 2*boxing;
        Object boxing1 = byteobj;
        byteobj=(Byte)boxing1;
        Integer.parseInt("9");
        System.out.println(Integer.toHexString(integerobj)); //c
        Integer.compare(9,9);
        System.out.println(130); //130
        System.out.println(Integer.bitCount(10));  //2
        System.out.println(Float.isNaN(0.0f / 0.0f)); //true

        /**f) Преобразование числа типа String*/
        String s34 = "2345";
        byte[] bytes=  s34.getBytes();
        String string = new String(bytes);
        System.out.println(string); //2345
        boolean b = Boolean.parseBoolean(s34);
        b = Boolean.valueOf(s34);
        s34 = "999000";
        String s35 = "999000";
        System.out.println(s34==s35);//true
        System.out.println(s34.equals(s35));//true
        System.out.println(s34.compareTo(s35));//0
        s35 = null;
        System.out.println(s34==s35);//false
        System.out.println(s34.equals(s35));//false
        //System.out.println(s34.compareTo(s35));//exception
        System.out.println(s34.indexOf('0'));//3
        System.out.println(s34.length());//6
        System.out.println(s34.replace('0', '9'));//999999
        System.out.println(s34.contains("99"));//true
        System.out.println(s34.hashCode());//168624055
        s34="l fyfy ytdy rd rt";
        String[] s36 = s34.split(" ");
        for (var i: s36) {
            System.out.println(i+"\t");
        }
        //TODO g) Какая из форм объявления многомерного массива допустима?
        char[][] c1; //Многомерных массивов не существует, но можно объявлять массив массивов
        char[] c2[];
        char c3 [][];
        char[] arraylenzero =  new char[0];
        c1 = new char[3][];
        c1[0] = new char[1];
        c1[1] = new char[2];
        c1[2] = new char[3];
        System.out.println(c1.length);//3
        System.out.println(c1[0].length);//1
        System.out.println(c1[1].length);//2
        System.out.println(c1[2].length);//3
        c2 = new char[2][];
        c3 = new char[2][];
        boolean comRez = c2==c3; //сравнение по ссылке
        System.out.println(comRez); //false
        c2 = c3;
        System.out.println(c2==c3); //true
        char[] c4 = new char[]{'f','w','b'};
        for (var c: c4){
            System.out.print(c);
        }
        //System.out.println(c4[6]);    java.lang.ArrayIndexOutOfBoundsException
    //TODO h
        WrapperString ws = new WrapperString("afaahdha");
        ws.replace('a', 'f');
        System.out.println("\n" + ws.getS());

        WrapperString anonimObj = new WrapperString("weofkewof") { // анонимный класс
            @Override
            public void replace(char oldchar, char newchar) {
                System.out.println("Переопределенный метод в анонимном классе");
            }
            public void delete(char oldchar) {
                System.out.println("Метод в анонимном классе");
                setS(getS().replace(oldchar, '\0'));
            }
        };
        anonimObj.replace ('w', 'b');
    }
}
