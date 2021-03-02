/**
 * 자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 변환하는 기술로,
 * JVM의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환함
 * (즉, Object를 "연속된 문장형데이터"나 "연속된 바이트"단위로 바꾸는 것임)
 *
 * 역직렬화 란 byte로 변환된 Data를 원래대로 Object나 Data로 변환하는 기술.
 * (즉, 직렬화된 바이트 형태의 데이터를 객체로 변환해서 JVM으로 상주시키는 형태)
 *
 * 직렬화를 통해 큰 작업 없이 보다 빠른 조회와 데이터의 매칭이 가능해짐
 * Object는 메모리에 존재하고, 추상적인데,,,string과 byte는 "드라이브에 저장"도 할 수 있고, "통신선에서 전송"도 할 수가 있다.
 */

import java.io.Serializable;

public class Test implements Serializable {
    private String str;
    private int ivalue;
    // 'static' or 'transient' key word 사용하면 직렬화 대상에서 제외됨

    public Test(String s, int i) {
        str = s;
        ivalue = i;
    }

    public String getString() {
        return str;
    }

    public int getInt() {
        return ivalue;
    }
}
