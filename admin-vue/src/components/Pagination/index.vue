<template>
<!-- :prev-text="上一页"
      :next-text="下一页"
      :hide-on-single-page="false" -->
  <div :class="{'hidden':hidden}" class="pagination-container">
    <el-pagination
      :background="background"
      :current-page.sync="currentPage"
      :page-size.sync="pageSize"
      :layout="layout"
      :page-sizes="pageSizes"
      :total="total"
      v-bind="$attrs"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
    />
  </div>
</template>

<script>
import { scrollTo } from '@/utils/scroll-to'

export default {
  name: 'Pagination',
  props: {
    //总条目数
    total: {
      required: true,
      type: Number
    },
    //当前页
    page: {
      type: Number,
      default: 1
    },
    //每页显示条数，默认20
    limit: {
      type: Number,
      default: 20
    },
    //下拉显示，每页显示个数选择器的选项设置
    pageSizes: {
      type: Array,
      default() {
        return [10, 20, 30, 50]
      }
    },
    //组件布局，子组件名用逗号分隔
    layout: {
      type: String,
      default: 'total, sizes, prev, pager, next, jumper'
    },
    //是否为分页按钮添加背景色
    background: {
      type: Boolean,
      default: true
    },
    autoScroll: {
      type: Boolean,
      default: true
    },
    hidden: {
      type: Boolean,
      default: false
    }
  },
  computed: {
    //当前页数，支持 .sync 修饰符
    currentPage: {
      get() {
        return this.page
      },
      set(val) {
        this.$emit('update:page', val)
      }
    },
    pageSize: {
      get() {
        return this.limit
      },
      set(val) {
        this.$emit('update:limit', val)
      }
    }
  },
  methods: {
    handleSizeChange(val) {
      this.$emit('pagination', { page: this.currentPage, limit: val })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    },
    handleCurrentChange(val) {
      this.$emit('pagination', { page: val, limit: this.pageSize })
      if (this.autoScroll) {
        scrollTo(0, 800)
      }
    }
  }
}
</script>

<style scoped>
.pagination-container {
  background: #fff;
  padding: 32px 16px;
}
.pagination-container.hidden {
  display: none;
}
</style>
