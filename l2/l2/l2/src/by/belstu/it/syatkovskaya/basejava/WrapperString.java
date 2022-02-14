package by.belstu.it.syatkovskaya.basejava;

import java.util.Objects;

public class WrapperString {
    /** @author Kate
     * @version 1.0*/

    private String str;
    public WrapperString(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }
    public void replace(char oldchar, char newchar){
        this.setStr(this.getStr().replace(oldchar, newchar));
    }
    public WrapperString delete(char newChar) {
        this.setStr(this.getStr().replace(newChar, '\0'));
        return this;
    }
}
