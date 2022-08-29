package com.example.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * get 请求返回结果对应的model
 *
 * @author LiXuekai on 2019/12/11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetResponseModel {
    /**
     * 0失败，1成功
     */
    @JSONField(ordinal = 1)
    private int returncode;
    /**
     * 返回的系统IP信息列表
     */
    @JSONField(ordinal = 2)
    private List<SyncIpAndHostName> msg;
    /**
     * 查询总记录数
     */
    @JSONField(ordinal = 3)
    private Integer totalNum;

}
