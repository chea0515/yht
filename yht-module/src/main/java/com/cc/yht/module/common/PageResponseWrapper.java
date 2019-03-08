package com.cc.yht.module.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageResponseWrapper<T> {

    private Boolean success = true;
    private Page<T> page = new Page<>();

    @Getter
    @Setter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Page<T> {

        private Integer pageNo;
        private Integer pageSize;
        private String order;
        private String orderBy;

        private Integer totalCount;
        private List<T> results;

        public Page<T> withPageNo(Integer pageNo) {
            this.pageNo = pageNo;
            return this;
        }

        public Page<T> withPageSize(Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Page<T> withTotalCount(Integer totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        public Page<T> withResults(List<T> results) {
            this.results = results;
            return this;
        }

        public Page<T> withOrder(String order) {
            this.order = order;
            return this;
        }

        public Page<T> withOrderBy(String orderBy) {
            this.orderBy = orderBy;
            return this;
        }
    }
}
