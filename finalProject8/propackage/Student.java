package student;
/**
*@author - Alexander Caines
*@since - 9/17/2018
*Title: Student.java
*Description: Manage a student's name and test scores.
*/

public class Student {

    // Class variable for default number of scores

    static public final int DEFAULT_NUM_SCORES = 3;

    //Instance variables
    //Each student object has a name and a set of test scores

    private String name;
    private int[] scores;

    //Constructors
    /**
    *@param name - String that represents the name of the object
    *@param numScores- integer representation of the number of scores in the scores array
    *The Student constructor takes (chained and
    *overrides the below constructor) a String name
    *and an integer numScores that represents the
    *numebr of scores to be inputted into the
    *scores array.
    *
    */
    public Student(String name, int numScores){
        this(name);//calls second constructor
        this.name = name;
        scores = new int[numScores];
    }

    /**
    *@param name - String that represents the name of the object
    *The Student constructor (chained to
    *the above constructor) takes in a
    *Student's name as a string and sets
    *it equal to the local name variable in the
    *Student class.
    */
    public Student(String name){
      this.name = name;
    }

    /**
    */
    public Student(){
        this("", DEFAULT_NUM_SCORES);
    }

    // String representation
    /**
    *Does not take any paramter
    *Does not return anything
    *The toString method gives a brief
    *overview of the incomiong object's
    *(reference constructors) data. This
    *includes the name of the Student,
    *their scores, and their average
    *scores. This is all returned as a
    *string to the command line.
    */
    public String toString(){
        String str;

        str = "Name:    " + name  + "\nScores:\n";
        for (int score : scores)
             str += score + "\n";
        str += "Average: " + getAverage();

        return str;
    }

    // Accessors and mutators
    /**
    *@param name The setName method takes a string parameter
    *accesses The name variable from the
    *incoming object and sets it to the
    *name variable in the local Student class.
    *
    */
    public void setName(String name){
         this.name = name;
    }
    /**
    *@return The getName method returns the name
    *stored in the name variable of the
    *object that interacted with one of
    *the constructors or setName.
    */
    public String getName(){
        return name;
    }
    /**
    *@param i - The setScore adds a score to the
    *scores array at the index i
    *@param newScore - New score added to scores array
    *Does not return anything
    */
    public void setScore(int i, int newScore){
        if(i<0 || i> scores.length){
            throw new IllegalArgumentException("i must be between 1 and "+scores.length);
        }
        if(newScore<0 || newScore > 100){
          throw new IllegalArgumentException("Scores must be between 1 and 100");
        }
        scores[i - 1] = newScore;
    }
    /**
    *@param i - the index at which the desired score is stored.
    *The getScore method returns the score
    *stored at the ith index in the scores
    *array as an integer. It takes the index
    *i as a paramter.
    *@return Returns the integer at the index i
    *in the array scores.
    */
    public int getScore(int i){
        if(i<0 || i> scores.length){
            throw new IllegalArgumentException("i must be between 1 and "+scores.length);
        }
        return scores[i - 1];
    }
    /**
    *Does not take any paramter
    * @return the integer length of the array scores
    *The getNumScores method returns the
    *number of scores in the scores array
    *as an int. It takes no parameters.
    */
    public int getNumScores(){
        return scores.length;
    }

    // Other methods
    /**
    *Does not take any paramter
    *@return double average of all of the scores in length
    *The getAverage method returns the
    *average of all of the scores in
    *the scores array as a double. It
    *takes no parameters.
    */
    public double getAverage(){//finished
      double average = 0.0;
      for(int i: scores){
        average+=i;
      }
      average = average/scores.length;
        return average;
    }
    /**
    *Does not take any paramter
    *@return integer maximum of the scores in the array scores
    *The getHighScore method returns the
    *highest score in the scores array as
    *an integer. It takes no parameters.
    */
    public int getHighScore(){//finished
        int max = 0;
        for(int i: scores){
          if(i>max){
            max = i;
          }
        }
        return max;
    }
}
