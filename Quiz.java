
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener {
    
    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String useranswers[][] = new String[10][1];
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit, lifeline;
    
    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    String name;
    
    Quiz(String name) {
        this.name = name;
        setBounds(50, 0, 1440, 850);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1440, 392);
        add(image);
        
        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);
        
        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

// Inside your Quiz constructor, replace your questions[][] and answers[][] with this:

        questions[0][0] = "Which data structure is used in Java to implement recursion internally?";
        questions[0][1] = "Queue";
        questions[0][2] = "Stack";
        questions[0][3] = "Heap";
        questions[0][4] = "Tree";

        questions[1][0] = "Which Java collection class allows duplicate elements and maintains insertion order?";
        questions[1][1] = "HashSet";
        questions[1][2] = "TreeSet";
        questions[1][3] = "ArrayList";
        questions[1][4] = "PriorityQueue";

        questions[2][0] = "What is the time complexity of searching an element in a HashMap in Java (average case)?";
        questions[2][1] = "O(n)";
        questions[2][2] = "O(log n)";
        questions[2][3] = "O(1)";
        questions[2][4] = "O(n log n)";

        questions[3][0] = "Which data structure is used in Java’s PriorityQueue class?";
        questions[3][1] = "Array";
        questions[3][2] = "Heap";
        questions[3][3] = "Linked List";
        questions[3][4] = "Stack";

        questions[4][0] = "Which traversal of a Binary Search Tree (BST) gives sorted output?";
        questions[4][1] = "Preorder";
        questions[4][2] = "Inorder";
        questions[4][3] = "Postorder";
        questions[4][4] = "Level order";

        questions[5][0] = "Which Java collection is best suited for implementing LRU Cache?";
        questions[5][1] = "TreeSet";
        questions[5][2] = "LinkedHashMap";
        questions[5][3] = "HashMap";
        questions[5][4] = "Vector";

        questions[6][0] = "What is the default load factor of HashMap in Java?";
        questions[6][1] = "0.25";
        questions[6][2] = "0.5";
        questions[6][3] = "0.75";
        questions[6][4] = "1.0";

        questions[7][0] = "Which algorithm is used in Collections.sort() method in Java 8 for non-primitive types?";
        questions[7][1] = "Merge Sort";
        questions[7][2] = "Quick Sort";
        questions[7][3] = "Tim Sort";
        questions[7][4] = "Heap Sort";

        questions[8][0] = "Which Java class provides a dynamic array implementation?";
        questions[8][1] = "Vector";
        questions[8][2] = "ArrayList";
        questions[8][3] = "LinkedList";
        questions[8][4] = "Stack";

        questions[9][0] = "Which data structure is used in Java to detect balanced parentheses efficiently?";
        questions[9][1] = "Queue";
        questions[9][2] = "Deque";
        questions[9][3] = "Stack";
        questions[9][4] = "PriorityQueue";

// Correct answers
        answers[0][1] = "Stack";
        answers[1][1] = "ArrayList";
        answers[2][1] = "O(1)";
        answers[3][1] = "Heap";
        answers[4][1] = "Inorder";
        answers[5][1] = "LinkedHashMap";
        answers[6][1] = "0.75";
        answers[7][1] = "Tim Sort";
        answers[8][1] = "ArrayList";
        answers[9][1] = "Stack";

        
        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.BLACK);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);
        
        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.BLACK);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);
        
        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.BLACK);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);
        
        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.BLACK);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1100, 550, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        add(next);
        
        lifeline = new JButton("50-50 Lifeline");
        lifeline.setBounds(1100, 630, 200, 40);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.setForeground(Color.BLACK);
        lifeline.addActionListener(this);
        add(lifeline);
        
        submit = new JButton("Submit");
        submit.setBounds(1100, 710, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(count);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
               useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;
            start(count);
        } else if (ae.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8 || count == 9) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit) {
            ans_given = 1;
            if (groupoptions.getSelection() == null) {
                useranswers[count][0] = "";
            } else {
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            for (int i = 0; i < useranswers.length; i++) {
                if (useranswers[i][0].equals(answers[i][1])) {
                    score += 10;
                } else {
                    score += 0;
                }
            }
            setVisible(false);
            new Score(name, score);
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 1100, 500);
        } else {
            g.drawString("Times up!!", 1100, 500);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ans_given == 1) {
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) {
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) { // submit button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                for (int i = 0; i < useranswers.length; i++) {
                    if (useranswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    } else {
                        score += 0;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else { // next button
                if (groupoptions.getSelection() == null) {
                   useranswers[count][0] = "";
                } else {
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                count++; // 0 // 1
                start(count);
            }
        }
        
    }
    
    public void start(int count) {
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        
        groupoptions.clearSelection();
    }
    
    public static void main(String[] args) {
        new Quiz("User");
    }
}
