package com.vilderlee.design.warpper;

/**
 * 类说明:
 *
 * <pre>
 * Modify Information:
 * Author        Date          Description
 * ============ ============= ============================
 * VilderLee    2019/7/1      Create this file
 * </pre>
 */
public class ShapeWrapper implements Shape {

    private Shape shape;

    public ShapeWrapper(Shape shape) {
        this.shape = shape;
    }

    @Override public void draw() {
        shape.draw();
    }

    public static void main(String[] args) {
        ShapeWrapper shapeWrapper = new ShapeWrapper(new Circle());
        shapeWrapper.draw();
    }
}
