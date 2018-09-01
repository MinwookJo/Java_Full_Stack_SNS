package dgsw.hs.kr.snsapplication.other_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//정규식클래스
public class PatternChecker {
    private static final String PasswrodPatternString = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()])(?=\\S+$).{8,16}$";

    private Pattern pattern;
    private Matcher matcher;
    //사용자 비밀번호 정규식 체크
    public boolean SignPasswordCheck(String password){
        pattern = Pattern.compile(PasswrodPatternString);
        matcher = pattern.matcher(password);
        if(matcher.find()){
            return true;
        }
        else{
            return false;
        }
    }

}
