package com.example.demo.login.domain.model;
import javax.validation.GroupSequence;

//バリデーション（入力チェック）のグループ実行　左のValidGroup１からバリデーションが行われる
@GroupSequence({ValidGroup1.class,ValidGroup2.class,ValidGroup3.class})
public interface GroupOrder {

}
