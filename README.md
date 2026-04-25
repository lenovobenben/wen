# wen

这个仓库整理了 B 站《算法太难了》系列视频对应的 Java 代码，并补充了一批常见经典算法题实现。代码按题目类型分包，适合用来快速查找某个算法模板、对照视频学习，或作为刷题时的参考实现。

## 项目结构

```text
src/main/java/
├── arr/           数组
├── backtracking/  回溯
├── binarySearch/  二分查找
├── bit/           位运算
├── dp/            动态规划
├── graph/         图算法
├── hash/          哈希表
├── heap/          堆
├── linkedList/    链表
├── math/          数学
├── matrix/        二维数组 / 矩阵
├── sort/          排序
├── stackQueue/    栈和队列
├── str/           字符串
├── tree/          二叉树
├── trie/          前缀树
├── twoPointers/   双指针 / 滑动窗口
└── unionFind/     并查集
```

辅助节点类位于 `linkedList/ListNode.java` 和 `tree/TreeNode.java`。新增题目的简单回归检查位于 `src/test/java/RecentAddedProblemsCheck.java`。

## 环境要求

- JDK 8+
- Maven 3.x

## 运行方式

编译并运行 Maven 默认检查：

```bash
mvn test
```

部分题目类包含 `main` 方法，可以直接在 IDE 中运行对应类查看示例输出。

## 命名约定

每个包按算法分类组织，类名大多使用 `Solution`、`Solution2`、`Solution3` 递增命名。具体题目和文件的对应关系以 README 中的表格为准。

## 视频代码对应表

| B站编号 | 力扣编号 | 代码位置 |
| ------------------------------------------------------------ | -------------------------------------- | ---------------------- |
| [【算法太难了】【1】斐波那契数列-动态规划入门（入坑？）](https://www.bilibili.com/video/BV14X4y1u7TV/) | 509. 斐波那契数 | dp/Solution.java |
| [【算法太难了】【2】连续子数组的最大和-动态规划](https://www.bilibili.com/video/BV1ka4y1H7ZQ/) | 剑指 Offer 42. 连续子数组的最大和 | dp/Solution2.java |
| [【算法太难了】【3】缺失的数字-二分](https://www.bilibili.com/video/BV1Fy4y1D7mA/) | 剑指 Offer 53 - II. 0～n-1中缺失的数字（视频中代码有BUG） | binarySearch/Solution.java |
| [【算法太难了】【4】搜索旋转数组-二分](https://www.bilibili.com/video/BV1h54y1t7vv/) | 33. 搜索旋转排序数组 | binarySearch/Solution2.java |
| [【算法太难了】【5】反转链表-链表](https://www.bilibili.com/video/BV1yK4y1V7Yx/) | 剑指 Offer 24. 反转链表 | linkedList/Solution.java |
| [【算法太难了】【6】删除链表的倒数第N个节点-链表&双指针](https://www.bilibili.com/video/BV1Ez4y1r7yD/) | 19. 删除链表的倒数第 N 个结点 | linkedList/Solution2.java |
| [【算法太难了】【7】二叉搜索树转双向链表-二叉树&递归](https://www.bilibili.com/video/BV11f4y1e7sf/) | 剑指 Offer 36. 二叉搜索树与双向链表（略不同） | tree/Solution.java |
| [【算法太难了】【8】平衡树检查-二叉树](https://www.bilibili.com/video/BV19V411b7Km/) | 110. 平衡二叉树 | tree/Solution2.java |
| [【算法太难了】【9】链表是否有环-双指针](https://www.bilibili.com/video/BV1Ky4y1v7xD/) | 141. 环形链表 | twoPointers/Solution.java |
| [【算法太难了】【10】最长无重复子串-双指针&哈希](https://www.bilibili.com/video/BV1uA411H7nU/) | 3. 无重复字符的最长子串 | twoPointers/Solution2.java |
| [【算法太难了】【11】用两个栈实现队列-栈&队列](https://www.bilibili.com/video/BV1aV411t7rP/) | 剑指 Offer 09. 用两个栈实现队列 | stackQueue/Solution.java |
| [【算法太难了】【12】括号序列-栈](https://www.bilibili.com/video/BV1xp4y1x7t4/) | 20. 有效的括号 | stackQueue/Solution2.java |
| [【算法太难了】【13】二叉树层序遍历-队列&二叉树](https://www.bilibili.com/video/BV1oA411H7Jc/) | 102. 二叉树的层序遍历 | stackQueue/Solution3.java |
| [【算法太难了】【14】缺失的数字-位运算](https://www.bilibili.com/video/BV19t4y1z7L5/) | 136. 只出现一次的数字 | bit/Solution.java |
| [【算法太难了】【15】二进制中1的个数-位运算](https://www.bilibili.com/video/BV1Kv4y1f7NB/) | 剑指 Offer 15. 二进制中1的个数 | bit/Solution2.java |
| [【算法太难了】【16】两数之和-哈希](https://www.bilibili.com/video/BV1Q54y1s7zi/) | 1. 两数之和 | hash/Solution.java |
| [【算法太难了】【17】最长公共子串-二维数组&字符串](https://www.bilibili.com/video/BV1S5411E7pd/) | 718. 最长重复子数组（略不同） | matrix/Solution.java |
| [【算法太难了】【18】像素翻转-二维数组](https://www.bilibili.com/video/BV1Ph41117uc/) | 面试题 01.07. 旋转矩阵 | matrix/Solution2.java |
| [【算法太难了】【19】基本字符串压缩-字符串](https://www.bilibili.com/video/BV1Rf4y1k7y9/) | 面试题 01.06. 字符串压缩（视频中代码有BUG） | str/Solution2.java |
| [【算法太难了】【20】翻转子串-字符串](https://www.bilibili.com/video/BV1p54y1p7Cu/) | 796. 旋转字符串 | str/Solution.java |
| [【算法太难了】【21】零钱兑换1-动态规划](https://www.bilibili.com/video/BV1Vv4y1Z7Sr/) | 518. 零钱兑换 II | dp/Solution3.java |
| [【算法太难了】【22】零钱兑换2-动态规划](https://www.bilibili.com/video/BV1UX4y1N766/) | 322. 零钱兑换（视频中代码有BUG） | dp/Solution4.java |
| [【算法太难了】【23】最长递增子序列-动态规划](https://www.bilibili.com/video/BV19b4y1R7K3/) | 300. 最长递增子序列 | dp/Solution5.java |
| [【算法太难了】【24】走方格-动态规划](https://www.bilibili.com/video/BV1Py4y1a7HP/) | 62. 不同路径 | dp/Solution6.java |
| [【算法太难了】【25】数据流中的中位数-堆](https://www.bilibili.com/video/BV1nv411h72m/) | 剑指 Offer 41. 数据流中的中位数 | heap/Solution.java |
| [【算法太难了】【26】从1加到N-递归](https://www.bilibili.com/video/BV1R54y1h7Si/) | 剑指 Offer 64. 求1+2+…+n | math/Solution2.java |
| [【算法太难了】【27】验证二叉搜索树-树](https://www.bilibili.com/video/BV1th411Q7DK/) | 98. 验证二叉搜索树 | tree/Solution3.java |
| [【算法太难了】【28】最近公共祖先-树](https://www.bilibili.com/video/BV1Db4y1X7Ws/) | 236. 二叉树的最近公共祖先 | tree/Solution4.java |
| [【算法太难了】【29】二叉树的镜像-树](https://www.bilibili.com/video/BV1nz4y1177w/) | 剑指 Offer 27. 二叉树的镜像 | tree/Solution5.java |
| [【算法太难了】【30】对称二叉树-树](https://www.bilibili.com/video/BV1k54y1a7en/) | 剑指 Offer 28. 对称的二叉树 | tree/Solution6.java |
| [【算法太难了】【31】单词距离-字符串](https://www.bilibili.com/video/BV1m64y1D7Aw/) | 面试题 17.11. 单词距离 | str/Solution3.java |
| [【算法太难了】【32】最长回文子串-字符串](https://www.bilibili.com/video/BV1Y5411P7rd/) | 5. 最长回文子串 | str/Solution4.java |
| [【算法太难了】【33】岛屿数量-二维数组&DFS](https://www.bilibili.com/video/BV1bb4y197zQ/) | 200. 岛屿数量 | matrix/Solution3.java |
| [【算法太难了】【34】最大黑方阵-二维数组&动态规划](https://www.bilibili.com/video/BV1TK411w7wN/) | 面试题 17.23. 最大黑方阵 | matrix/Solution4.java |
| [【算法太难了】【35】二维数组中的查找-二维数组&双指针](https://www.bilibili.com/video/BV1DA411N7Md/) | 剑指 Offer 04. 二维数组中的查找 | matrix/Solution5.java |
| [【算法太难了】【36】矩阵中的路径-二维数组&DFS&回溯](https://www.bilibili.com/video/BV1Dh411S7v5/) | 剑指 Offer 12. 矩阵中的路径 | matrix/Solution6.java |
| [【算法太难了】【37】最大数-排序](https://www.bilibili.com/video/BV1xp4y187pJ/) | 179. 最大数 | sort/Solution.java |
| [【算法太难了】【38】合并两个有序数组-排序&双指针](https://www.bilibili.com/video/BV1264y1U7nR/) | 88. 合并两个有序数组 | sort/Solution2.java |
| [【算法太难了】【39】合并K个升序链表-排序&链表&堆](https://www.bilibili.com/video/BV1QK4y1N7ww/) | 23. 合并K个升序链表 | sort/Solution3.java |
| [【算法太难了】【40】排序链表-归并排序](https://www.bilibili.com/video/BV1Ti4y1N7hU/) | 148. 排序链表 | sort/Solution4.java |
| [【算法太难了】【41】链表的第一个公共节点-链表](https://www.bilibili.com/video/BV1oZ4y1c73R/) | 剑指 Offer 52. 两个链表的第一个公共节点 | linkedList/Solution3.java |
| [【算法太难了】【42】删除链表中的节点-链表](https://www.bilibili.com/video/BV1Y64y1v7e7/) | 237. 删除链表中的节点 | linkedList/Solution4.java |
| [【算法太难了】【43】旋转数组-数组](https://www.bilibili.com/video/BV1X64y1S7a4/) | 189. 旋转数组 | arr/Solution.java |
| [【算法太难了】【44】接雨水-数组&动态规划](https://www.bilibili.com/video/BV1Vv41177GE/) | 42. 接雨水 | arr/Solution2.java |
| [【算法太难了】【45】多数元素-数组](https://www.bilibili.com/video/BV1tU4y1b7pX/) | 169. 多数元素 | arr/Solution3.java |
| [【算法太难了】【46】移动零-数组](https://www.bilibili.com/video/BV1Xv41177nN/) | 283. 移动零 | arr/Solution4.java |
| [【算法太难了】【47】打家劫舍-动态规划](https://www.bilibili.com/video/BV1CN411f7Li/) | 198. 打家劫舍 | dp/Solution7.java |
| [【算法太难了】【48】买卖股票1-数组](https://www.bilibili.com/video/BV1QN411f794/) | 121. 买卖股票的最佳时机 | arr/Solution5.java |
| [【算法太难了】【49】买卖股票2-数组](https://www.bilibili.com/video/BV19q4y1J7ak/) | 122. 买卖股票的最佳时机 II | arr/Solution6.java |
| [【算法太难了】【50】Java计算圆周率到10000位-大数运算](https://www.bilibili.com/video/BV1vN411f7W1/) | 优化后的圆周率计算 | math/Solution3.java |
| [【算法太难了】【51】实现LRU缓存-LinkedHashMap](https://www.bilibili.com/video/BV1Dg411378i/) | 面试题 16.25. LRU 缓存 | hash/LRUCache.java |
| [【算法太难了】【52】回文排列-哈希](https://www.bilibili.com/video/BV1aV41147QY/) | 面试题 01.04. 回文排列 | hash/Solution2.java |
| [【算法太难了】【53】数组中重复的数字-原地哈希](https://www.bilibili.com/video/BV1BV41147Ek/) | 剑指 Offer 03. 数组中重复的数字 | hash/Solution3.java |
| [【算法太难了】【54】盛最多水的容器-双指针](https://www.bilibili.com/video/BV14w411f7v3/) | 11. 盛最多水的容器 | twoPointers/Solution3.java |
| [【算法太难了】【55】长度最小的子数组-双指针&滑动窗口](https://www.bilibili.com/video/BV1X5411K7ja/) | 209. 长度最小的子数组 | twoPointers/Solution4.java |
| [【算法太难了】【56】和为s的两个数字-双指针](https://www.bilibili.com/video/BV1TV411W7fx/) | 剑指 Offer 57. 和为s的两个数字 | twoPointers/Solution5.java |
| [【算法太难了】【57】调整数组顺序使奇数位于偶数前面-双指针](https://www.bilibili.com/video/BV1b64y1b7ia/) | 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面 | twoPointers/Solution6.java |
| [【算法太难了】【58】配对交换-位运算](https://www.bilibili.com/video/BV1cK4y1u7fy/) | 面试题 05.07. 配对交换 | bit/Solution3.java |
| [【算法太难了】【59】扑克牌中的顺子-数学](https://www.bilibili.com/video/BV13U4y137dg/) | 剑指 Offer 61. 扑克牌中的顺子 | math/Solution.java |
| [【算法太难了】【60】将有序数组转换为二叉搜索树-二叉树&二分&递归](https://www.bilibili.com/video/BV1Cv411J7Vn/) | 108. 将有序数组转换为二叉搜索树 | tree/Solution7.java |

## 新增经典算法题（无视频）

| 名称 | 代码位置 |
| ------------------------------ | --------------------------- |
| 经典 N 皇后问题 (默认 8 皇后) | backtracking/Solution.java |
| 93. 复原 IP 地址 (Restore IP Addresses) | backtracking/Solution2.java |
| 72. 编辑距离 (Edit Distance) | dp/Solution8.java |
| 1584. 连接所有点的最小费用 (Prim 算法，曼哈顿距离) | graph/Solution.java |
| Dijkstra 算法实现 (基于最小堆优化) | graph/Solution2.java |
| 计算自然常数 e | math/Solution4.java |
| 计算 ln(2) | math/Solution5.java |
| 84. 柱状图中最大的矩形 | stackQueue/Solution4.java |
| 基础计算器 (支持 + - * / ( ) 和 整数) | stackQueue/Solution5.java |
| 28. 实现 strStr() (KMP 算法) | str/Solution5.java |
| 208. 实现 Trie (前缀树) | trie/Solution.java |
| 15. 三数之和 (3Sum) | twoPointers/Solution7.java |
| 经典算法：并查集 (Union-Find) | unionFind/Solution.java |
| 207. 课程表 | graph/Solution3.java |
| 1143. 最长公共子序列 | dp/Solution9.java |
| 76. 最小覆盖子串 | str/Solution6.java |
| 105. 从前序与中序遍历构造二叉树 | tree/Solution8.java |
| 124. 二叉树中的最大路径和 | tree/Solution9.java |
| 215. 数组中的第K个最大元素 | heap/Solution2.java |
| 56. 合并区间 | sort/Solution5.java |

