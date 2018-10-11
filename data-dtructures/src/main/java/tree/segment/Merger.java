package tree.segment;

/**
 * 融合器, 
 * 用于将两个元素融合成一个元素
 * 配合线段树的合并操作使用
 * @author 七夜雪
 *
 */
@FunctionalInterface
public interface Merger<E> {
	E merge(E a, E b);
}
