package com.gac.codingGame.seeder;

import com.gac.codingGame.codingQuestion.CodingQuestionRepository;
import com.gac.codingGame.codingQuestion.entities.CodingQuestion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CodingQuestionDataSeeder implements CommandLineRunner {
    private final CodingQuestionRepository codingQuestionRepository;


    public CodingQuestionDataSeeder(CodingQuestionRepository codingQuestionRepository) {
        this.codingQuestionRepository = codingQuestionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (codingQuestionRepository.count()==0) {
            {
            String questionTitle = "Two Sum";
            String questionDesc = "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\\n\\nYou may assume that each input would have exactly one solution, and you may not use the same element twice.\\n\\nYou can return the answer in any order.";
            String difficulty = "Easy";
            String exampleStr11 = "input: \"nums = [2,7,11,15], target = 9\", output: \"[0,1]\", explanation: \"Because nums[0] + nums[1] == 9, we return [0, 1].";
            String exampleStr12 =  "input: \"nums = [3,2,4], target = 6\", output: \"[1,2]\", explanation: \"\" ";
            String exampleStr13 = "input: \"nums = [3,3], target = 6\", output: \"[0,1]\", explanation: \"\"";
            String[] examples1 = {exampleStr11, exampleStr12, exampleStr13};
            String constraints = "2 ≤ nums.length ≤ 10⁴\", \"-10⁹ ≤ nums[i] ≤ 10⁹\", \"-10⁹ ≤ target ≤ 10⁹\", \"Only one valid answer exists.";
            String hints = "A really brute force way would be to search for all possible pairs of numbers but that would be too slow.,\n" +
                    "So we need to find a way to speed up the look up. Is there a data structure that has fast look up?,\n" +
                    "The second train of thought is, instead of looking at every possible pair, what if we iterated through the array once, and for each value, we searched for target - nums[i]?";
            String test11 = "input: { nums: [2, 7, 11, 15], target: 9 }, expected: [0, 1]";
            String test12 = "input: { nums: [3, 2, 4], target: 6 }, expected: [1, 2] ";
            String test13 = "input: { nums: [3, 3], target: 6 }, expected: [0, 1]";
            String test14 = "input: { nums: [-1, -2, -3, -4, -5], target: -8 }, expected: [2, 4]";
            String[] testCases = {test11,test12, test13, test14};
            String helperFunction = "";
            String solution = "function twoSum(nums, target) {\n" +
                    "  const map = new Map();\n" +
                    "  for (let i = 0; i < nums.length; i++) {\n" +
                    "    const complement = target - nums[i];\n" +
                    "    if (map.has(complement)) {\n" +
                    "      return [map.get(complement), i];\n" +
                    "    }\n" +
                    "    map.set(nums[i], i);\n" +
                    "  }\n" +
                    "  return [];\n" +
                    "}";
            String functionName = "twoSum";
            String starterCode = "function twoSum(nums, target) {\\n  // Write your solution here\\n  \\n};";
            codingQuestionRepository.saveAndFlush((new CodingQuestion(questionTitle,questionDesc,functionName, starterCode,hints,examples1,helperFunction,constraints,solution,difficulty,testCases)));
            }
            {
                String questionTitle2 = "Add Two Numbers";
                String questionDesc2 = "You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.\\n\\nYou may assume the two numbers do not contain any leading zero, except the number 0 itself";
                String difficulty2 = "Medium";
                String exampleStr21 = "input: \"l1 = [2,4,3], l2 = [5,6,4]\", output: \"[7,0,8]\", explanation: \"342 + 465 = 807.\"";
                String exampleStr22 =  "input: \"l1 = [0], l2 = [0]\", output: \"[0]\", explanation: \"\"";
                String exampleStr23 = "input: \"l1 = [9,9,9], l2 = [9,9]\", output: \"[8,9,0,1]\", explanation: \"\"";
                String[] examples2 = {exampleStr21, exampleStr22, exampleStr23};
                String constraints2 = "The number of nodes in each linked list is in the range [1, 100].,\n" +
                        "0 <= Node.val <= 9,\n" +
                        "It is guaranteed that the list represents a number that does not have leading zeros.";
                String hints2 = "\"Try to simulate the addition by hand.\", \"You might need to handle a carry-over digit.\"";
                String test21 = "input: { l1: [2, 4, 3], l2: [5, 6, 4] }, expected: [7, 0, 8] ";
                String test22 = "input: { l1: [0], l2: [0] }, expected: [0] ";
                String test23 = "input: { l1: [9, 9, 9, 9, 9, 9, 9], l2: [9, 9, 9, 9] }, expected: [8, 9, 9, 9, 0, 0, 0, 1] ";
                String[] testCases2 = {test21,test22, test23};
                String helperFunction2 = "";
                String functionName2 = "addTwoNumber";
                String starterCode2 = "// Definition for singly-linked list.\\n// function ListNode(val, next) {\\n//     this.val = (val===undefined ? 0 : val)\\n//     this.next = (next===undefined ? null : next)\\n// }\\n\\nfunction addTwoNumbers(l1, l2) {\\n  // Write your solution here\\n\\n};;";
                String solution2 ="function addTwoNumbers(l1, l2) {\n" +
                        "    // Helper to convert array to linked list\n" +
                        "    function arrayToLinkedList(arr) {\n" +
                        "        let head = new ListNode(arr[0]);\n" +
                        "        let current = head;\n" +
                        "        for (let i = 1; i < arr.length; i++) {\n" +
                        "            current.next = new ListNode(arr[i]);\n" +
                        "            current = current.next;\n" +
                        "        }\n" +
                        "        return head;\n" +
                        "    }\n" +
                        "    l1 = Array.isArray(l1) ? arrayToLinkedList(l1) : l1;\n" +
                        "    l2 = Array.isArray(l2) ? arrayToLinkedList(l2) : l2;\n" +
                        "\n" +
                        "    let dummyHead = new ListNode(0);\n" +
                        "    let p = l1, q = l2, current = dummyHead;\n" +
                        "    let carry = 0;\n" +
                        "    while (p !== null || q !== null) {\n" +
                        "        let x = (p !== null) ? p.val : 0;\n" +
                        "        let y = (q !== null) ? q.val : 0;\n" +
                        "        let sum = carry + x + y;\n" +
                        "        carry = Math.floor(sum / 10);\n" +
                        "        current.next = new ListNode(sum % 10);\n" +
                        "        current = current.next;\n" +
                        "        if (p !== null) p = p.next;\n" +
                        "        if (q !== null) q = q.next;\n" +
                        "    }\n" +
                        "    if (carry > 0) {\n" +
                        "        current.next = new ListNode(carry);\n" +
                        "    }\n" +
                        "\n" +
                        "    // Helper to convert linked list back to array for comparison\n" +
                        "    let result = [];\n" +
                        "    let curr = dummyHead.next;\n" +
                        "    while(curr) {\n" +
                        "        result.push(curr.val);\n" +
                        "        curr = curr.next;\n" +
                        "    }\n" +
                        "    return result;\n" +
                        "}";
                codingQuestionRepository.saveAndFlush((new CodingQuestion(questionTitle2,questionDesc2,functionName2, starterCode2,hints2,examples2,helperFunction2,constraints2,solution2,difficulty2,testCases2)));
            }
        }
    }
}
