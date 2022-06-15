/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hieunt.mathutil.test.core;

import com.hieunt.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Masterkien
 */
//câu lệnh của Junit báo hiệu rằng sẽ cần loop qua tập data để
//lấy cặp data input/expected nhồi vào hàm test
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
        
        //ta trả về mảng 2 chiều gồm nhiều cặp Expected|Input
        @Parameterized.Parameters //Junit sẽ ngầm chạy loopqua từng dòng
        //của mảng để lấy ra đc cặp data input/expected
        //tên hàm ko quan trọng, quan trọng là @
        public static Object[][] initData(){
            return new Integer[][]{
                {0,1},
                {1,1},
                {2,2},
                {3,6},
                {4,24},
                {6,720}
            };
        }
     //giả sử loop qua từng dòng cùa mảng, ta cần gán từng value của cột
        //vào biến tương ứng input, expected để lát hồi feed cho hàm
        @Parameterized.Parameter(value = 0) //map với mảng data
        public int n; // biến map với value cột 0 của mảng
                @Parameterized.Parameter(value = 1)
        public long expected; //kiểu long vì giá trị trả về của hàm getF() là long
                
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell(){
        Assert.assertEquals(expected, MathUtil.getFactorial(n));
    }
}
