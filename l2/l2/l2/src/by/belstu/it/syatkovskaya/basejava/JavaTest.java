package by.belstu.it.syatkovskaya.basejava;
import static java.lang.Math.*;

public class JavaTest {
    public static void main(String[] args) {
        //b
        char chaR = '5';
        int inT = 555555;
        short shoRt;
        byte byTe;
        long lonG;
        boolean bool;
        double douBle = 5.4;
        String str = "String";
        System.out.println(str + inT);
        System.out.println(str + chaR);
        System.out.println(str + douBle);
        // byTe = byTe + inT;//Error
        // inT = douBle + lonG;//Error
        lonG = inT + 2147483647;
        System.out.println(-lonG);
        //static int siNt;
        System.out.println(true && false);
        System.out.println(true ^ false);
        //System.out.println(true + false);
        long l1 = 9223372036854775807L, l2 = 0x7fff_ffff_fffL;
        char ch1 = 'a', ch2 = '\u0061', ch3 = 97;
        System.out.println("" + ch1 + ch2 + ch3);
        System.out.println(3.45 % 2.4);
        System.out.println(1.0 / 0.0);
        System.out.println(0.0 / 0.0);
        System.out.println(log(-345));
        System.out.println(Float.intBitsToFloat(0x7F800000));
        System.out.println(Float.intBitsToFloat(0xFF800000));

        //d
        System.out.println(PI);
        System.out.println(E);
        System.out.println(Math.round(PI));
        System.out.println(Math.round(E));
        System.out.println(Math.min(PI, E));
        System.out.println(Math.random());

        //e
        Boolean bo = false;
        Character cha = 'a';
        Integer num = 19;
        Byte byt = 4;
        Short sho = 25;
        Long lon = 5151165L;
        Double dou = 5.1824;
        System.out.println(bo & true);
        System.out.println(byt >>> 1);
        System.out.println(~num);
        System.out.println(lon * sho);
        System.out.println(Long.MAX_VALUE + "..." + Long.MIN_VALUE);
        System.out.println(Double.MAX_VALUE + "..." + Double.MIN_VALUE);
        int nuM= num;
        byte byT = byt;
        System.out.println(Integer.parseInt("8465"));
        System.out.println(Integer.toHexString(29));
        System.out.println(Integer.compare(num, 9));
        System.out.println(num.toString());
        System.out.println(Integer.bitCount(num));

        //f
        String s34 = "2345";
        int num1 = Integer.valueOf(s34);
        System.out.println(num1);
        System.out.println(Integer.parseInt(s34));
        byte[] mas = s34.getBytes();
        String str1 = new String(mas);
        System.out.println(Boolean.parseBoolean(s34));
        System.out.println(Boolean.valueOf(s34));
        String st1 = "Kate", st2 = "Kate";
        /**
         * @value Kate
         * @see
         */
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
        System.out.println(st1.compareTo(st2));
        st2 = null;
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
        //System.out.println(st1.compareTo(st2));
        String[] strMas = st1.split("a");
        System.out.println(strMas[0] + " " + strMas[1]);
        System.out.println(st1.contains("j"));
        System.out.println(st1.hashCode());
        System.out.println(st1.indexOf('t'));
        System.out.println(st1.length());
        System.out.println(st1.replace('a', 'e'));

        //g
        char[][] c1;
        char[] c2[];
        char c3[][];
        c1 = new char[3][];
        System.out.println(c1.length);
        for (int i = 0; i < c1.length; i++) {
            c1[i] = new char[i + 1];
            System.out.println("Длина строки "+ c1[i].length);
        }
        c2 = new char[][]{{'1', '2', '3'}, {'1', '2', '3'}, {'1', '2', '3'}};
        c3 = new char[][]{{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        boolean comRez = c2 == c3;
        c2 = c3;
        for (char[] ind1 : c2) {
            for (char ind2 : ind1) {
                System.out.println(ind2);
            }
        }
       //System.out.println(c2[2][4]);// java.lang.ArrayIndexOutOfBoundsException

      //h
        var wS= new WrapperString("Hello World");
        wS.replace('l','f');
        System.out.println(wS.getStr());
        wS.delete('o');
        System.out.println(wS.getStr());
        /**@return "Heffo Worfd"
         * @throws
         * @param
         */
    }
}
