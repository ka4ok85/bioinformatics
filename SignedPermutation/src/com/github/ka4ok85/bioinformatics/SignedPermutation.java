package com.github.ka4ok85.bioinformatics;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Ineffective re-usage of Johnson-Trotter Algorithm. Generates all permutations for 2n and picks up unique substrings using HashSet
 */
public class SignedPermutation {
	private int[] elements;
    private int[] direction;
   
    private int lastMovedIndex;

    public SignedPermutation(int[] elements) {
        super();
        this.elements = elements;
       
        // 0 - left direction
        // 1 - right direction
        direction = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            direction[i] = 0;
        }
    }
   
    public void generate() {
        int permutationsCount = factorial(elements.length);
        int[] res = Arrays.copyOfRange(elements, 0, elements.length/2);
        
        HashSet<String> set = new HashSet<String>();
        set.add(implode(" ", res));

        int moveIndex;
        while (permutationsCount > 1) {

            moveIndex = findMovingElement();
            if (moveIndex < 0) {
                throw new RuntimeException();
            } else {
                moveElement(moveIndex);
                if (1 == 1) {
                	res = Arrays.copyOfRange(elements, 0, elements.length/2);
                	boolean contains = duplicates(res, elements.length/2);
                	if (contains == false) {
                		set.add(implode(" ", res));
                	}
                }                

                permutationsCount--;
            }
        }
        
        for (String string : set) {
        	System.out.println(string);
		}
    }
   
    static boolean duplicates(final int[] list, int correction) {
       final int max = 100;
       boolean[] bitmap = new boolean[max];
       for (int item : list) {
    	   item = Math.abs(item);
    	   if (!(bitmap[item] ^= true)) { 
    		   return true;
    	   }
       }

       return false;
    }
    
    private void moveElement(int index) {
        if (direction[index] == 0 ) {
            // left element does not exist
            if (index == 0) {
                // empty
            } else {
                // swap element (and corresponding direction) with previous one
                elements[index] = elements[index]^elements[index-1];
                elements[index-1] = elements[index]^elements[index-1];
                elements[index] = elements[index]^elements[index-1];
               
                direction[index] = direction[index]^direction[index-1];
                direction[index-1] = direction[index]^direction[index-1];
                direction[index] = direction[index]^direction[index-1];
               
                lastMovedIndex = index-1;
            }
        } else {
            // right element does not exist
            if (index == elements.length - 1) {
                // empty
            } else {
                // swap element (and corresponding direction) with next one
                elements[index] = elements[index]^elements[index+1];
                elements[index+1] = elements[index]^elements[index+1];
                elements[index] = elements[index]^elements[index+1];
               
                direction[index] = direction[index]^direction[index+1];
                direction[index+1] = direction[index]^direction[index+1];
                direction[index] = direction[index]^direction[index+1];
               
                lastMovedIndex = index+1;
            }
        }
       
        // change direction for all elements gt moving element
        for (int i = 0; i < elements.length; i++) {
            if (elements[lastMovedIndex] < elements[i]) {
                direction[i] = direction[i] ^ 1;
            }
        }
    }
   
    private int findMovingElement() {
        int result = -1;
        int max = -1000;
        for (int i = 0; i < elements.length; i++) {
            // left direction
            if (direction[i] == 0) {
                // left element does not exist
                if (i == 0) {
                	continue;
                } else {
                    if (elements[i] > elements[i-1] && elements[i] > max) {
                        result = i;
                        max = elements[i];
                    }
                }
            } else {
                // right element does not exist
                if (i == elements.length - 1) {
                     continue;
                } else {
                    if (elements[i] > elements[i+1] && elements[i] > max) {
                        result = i;
                        max = elements[i];
                    }
                }
            }
        }
       
        return result;
    }
   
    public static int factorial(int n) {
        int ret = 1;
        for (int i = 1; i <= n; ++i) {
        	ret *= i;
        }

        return ret;
    }

    public static int getSignedPermutationsCount(int n) {
        int ret = 1;
        for (int i = 1; i <= n; i++) {
        	ret = ret*i*2;
        }

        return ret;
    }
    
    private String implode(String spacer,int[] in_array){
        String res = "";
        for(int i = 0 ; i < in_array.length ; i++){
            if(!res.equals("")) {
                res += spacer;
            }

            res += in_array[i];
        }

        return res;
    }
}
