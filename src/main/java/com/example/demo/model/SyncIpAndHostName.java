package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * get 请求返回结果对应的model
 *
 * @author zhangqy
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SyncIpAndHostName {

    private String pageNo;

    private String pageSize;

}
