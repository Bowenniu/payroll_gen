# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   The CSV stands for Comma-Seperated Values. It is a simple file formate
   which is used to store tabular data in simple text form, such as
   spreadsheets or database.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
   It is because 'List<IEmployee>' allows to store the objects of any class that implements the 
   IEmployee interface. The list may contain any objects. While 'ArrayList<HourlyEmployee>'specified the 
   object that can be used.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
     "Is-a" represents the inheritance relationship between classes or between a class and an interface, while "Has-a" represents the dependency relationship between objects and their members.

4. Can you provide an example of a has-a relationship in your code (if one exists)?


5. Can you provide an example of an is-a relationship in your code (if one exists)?


6. What is the difference between an interface and an abstract class?
     Interfaces require implementation using the implements, while abstract classes require inheritance using the extend. A class can implement multiple interfaces, while a class can only inherite from one abstract class.

7. What is the advantage of using an interface over an abstract class?
    1. Flexibility
    2. Interface can implement multiple, while abstract class can only do one.
    3. Testable. 


8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
    The code is not valid. 
    List<Integer> numbers = new ArrayList<>(); this should do it.

9. Which class/method is described as the "driver" for your application? 
    PayrollGenerator


10. How do you create a temporary folder for JUnit Testing? 
    use the TemporaryFolder provided in junit library.

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

It is important to know that each employee are being paid fairly. To help the workers have a better understand on their level of salary, the following methods can be used to improve the system:
1. Discover what over people in the save field are making, datas can be drawed from job research websites as Glassdoor / Payscale (How Do I Know if I’m Being Compensated Fairly Compared to My Peers?)*1 The system could help the user to calculate the average salary and tell them if their salary is higher or lower than the average salary.
2. The system can be improved to create a diagram of raise or promotion, so that the users are able to view their salary level in a 3D view. "When first securing a job at the beginning of your career, it's possible that you initially accepted a lower-than-average salary. However, you can always earn raises over time to get it up to a fairer level. If you've been in your role for a few years but your salary hasn't increased, then you may be underpaid." *2


cite:
*1 https://www.sommerspc.com/blog/2023/03/how-do-i-know-if-im-being-compensated-fairly-compared-to-my-peers/#:~:text=Discover%20what%20other%20people%20in,it's%20a%20great%20starting%20point. accessed May 31

*2 https://www.indeed.com/career-advice/pay-salary/i-am-underpaid accessed May 31