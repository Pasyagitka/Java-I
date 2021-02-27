package by.belstu.it.zinovich.basejava;

import java.util.Objects;

/**h) WrapperString*/
public class WrapperString {
    private String s;
    public void setS(String s) {
        this.s = s;
    }
    public String getS() {
        return s;
    }
    public WrapperString(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(s, that.s);
    }

    @Override
    public String toString() {
        return "WrapperString{" +
                "s='" + s + '\'' +
                '}';
    }


    @Override
    public int hashCode() {
        return Objects.hash(s);
    }

    public void replace (char oldchar, char newchar){
        s = s.replace(oldchar, newchar);
    }

}
