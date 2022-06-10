/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hieunt.mathutil.test.core;

//import org.junit.Test;

import com.hieunt.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

//import static org.junit.Assert.*;

/**
 *
 * @author ntrun
 */
public class MathUtilTest {
    //Đây là class sẽ sử dụng các hàm của thư viện/framework Junit 
    //Để kiểm thử/kiểm tra code chính - hàm tínhGiaiThua() bên 
    // class core.MathUtil 
    //viết code để test code bên kia 
    
    //có quy tắt đặt tên hàm kiểm thử nhưng thường sẽ là nói lên mục địch của kiểm thử của các case/ tình huống kiẻm thử
    //tình xuống xài app thành công hay thất bại
    
    //hàm chạy thành công trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6!, ko đưa -5!, 30!
    
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này 
    //@Test phía hậu trường là public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau về kiểm thử hàm tính giai thừa 
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell(){
        int n = 0;  // test thử tình huống tử tế đầu vào
        long expected = 1;  //hy vọng rằng 0! = 1
//        long actual = ; //gọi hàm cần test bên core/app chính/ code chính
        long actual = MathUtil.getFactorial(n);
        
        //so sánh expected vs. actual dùng  xanh xanh đỏ đỏ, framework
        Assert.assertEquals(expected, actual);
        
        //Gộp thêm vài case thành công nữa/đưa đầu vào ngon!!! Hàm phải tính ngon 
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        Assert.assertEquals(2, MathUtil.getFactorial(2));
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        Assert.assertEquals(120, MathUtil.getFactorial(5));
        Assert.assertEquals(720, MathUtil.getFactorial(6));
        
        //Hàm giúp so sánh 2 giá trị nào đó có giống nhau không
        //Nếu giống -> thảy màu xanh - code ngon 
        //              ít nhất cho case đang test
        //Nếu ko giống nhau -> nếu thảy màu đỏ 
        //                      hàm ý expected và actual ko giống nhau
    }
    
    //hàm getF() ta thiết kế có 2 tình huống xử lý
    //1. đưa data tử tế từ 0 tới 20 phải tính đc n!
    //2. đưa data âm hoặc >20, thiết kế của hàm phải ném ra ngoại lệ
    //TAO KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N<0 HOẶC N>20
    //RẤT MONG ngoại lệ xuất hiện với n cà chớn này
    
    //nếu hàm nhận vào n<0 hoặc n>20 và hàm ném ra ngoại lệ thì nói hàm chạy đúng như thiết kế
    // --> xanh phải xuất hiện
    
    //nếu hàm nhận n sai mà ko ném ra ngoại lệ thì chắc chắn hàm chạy sai thiết kế
    
    //test case
    //input -5
    //expected: IllegalArgumentException xuất hiện
    
    //tình huống bất thường, noại lệ, ngoài dự tính, dự liệu
    //là những thứ ko thể đo lường so sánh theo kiểu value
    //mà chỉ có thể đo lường = cách chúng có xuất hiện hay ko
    // assortEquals() ko dùng để so sánh 2 ngoại lệ
    // equals() là bằng nhau hay ko trên value
    
    
    //đỏ do hàm đúng là có ném ngoại lệ
    //nhưng ko phải là ngoại lệ như kì vọng
    //chứ ko phải hàm ném sai
//    @Test(expected = NumberFormatException.class)
//    public void testGetFactorialGivenWrongArgumentThrowsException(){
//        MathUtil.getFactorial(-5); //hàm @Test chạy hay getF90 chạy 
//                                    //sẽ ném về ngoại lệ NumberFormat...
//    }
    
    
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenWrongArgumentThrowsException(){
        MathUtil.getFactorial(-5); //hàm @Test chạy hay getF90 chạy 
                                    //sẽ ném về ngoại lệ NumberFormat...
    }   
    //cách khác để bắt ngoại lệ xuất hiện
    //xài lambda
    //test case hàm sẽ ném về ngoại lệ nếu nhận về 21
    //t cần thấy màu xanh khi chơi với 21!
    
//    @Test()
//    public void testGetFactorialGivenWrongArgumentThrowsException_LamdaVersion(){
//        Assert.assertThrows(tham số 1: loại ngoại lệ muốn so sánh,
//                            tham số 2: đoạn code chạy văng ra ngoại lệ runable);
//                            Assert.assertThrows(IllegalAccessException.class, () -> MathUtil.getFactorial(-5));
//        MathUtil.getFactorial(-5); //hàm @Test chạy hay getF90 chạy 
//                                    //sẽ ném về ngoại lệ NumberFormat...
//    }  
    
    
    //bắt ngoại lệ xem hàm có ném ngoại lệ hay ko khi n cà chớn
    //có ném tức là hàm chạy đúng thiết kế
    @Test()
    public void testGetFactorialGivenWrongArgumentThrowsException_LamdaVersion(){
//        chủ động kiểm soát ngoại lệ
        try {
                    MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bat81 try catch la2 junit xanh vi2 co1 kiem63 soat1 ngoai5 le65 nhung7 ko chac81 có ngoại lệ hay ko
            //có d9aon5 code kiểm soát đúng ngoại lệ IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. N must be between 0..20", e.getMessage());
        }
    }  
}
