package kr.hs.dgsw.mini_sns.Model;

public class BoardDomain {
    public int idx;
    public String title;
    public String content;
    public UserDomain snsUser;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserDomain getSnsUser() {
        return snsUser;
    }

    public void setSnsUser(UserDomain snsUser) {
        this.snsUser = snsUser;
    }
}
