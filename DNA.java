//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:  DNA.java
// Course: CS300 Spring 2022
//
// Author: Ark Dutt 
// Email: dutt3@wisc.edu
// Lecturer: Prof.Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////

public class DNA extends Object {

  protected LinkedQueue <Character> DNA = new LinkedQueue<>();

  protected static String[][] mRNAtoProteinMap =
          {{"UUU", "F"}, {"UUC", "F"}, {"UUA", "L"}, {"UUG", "L"}, {"UCU", "S"}, {"UCC", "S"},
                  {"UCA", "S"}, {"UCG", "S"}, {"UAU", "Y"}, {"UAC", "Y"}, {"UAA", "STOP"}, {"UAG", "STOP"},
                  {"UGU", "C"}, {"UGC", "C"}, {"UGA", "STOP"}, {"UGG", "W"}, {"CUU", "L"}, {"CUC", "L"},
                  {"CUA", "L"}, {"CUG", "L"}, {"CCU", "P"}, {"CCC", "P"}, {"CCA", "P"}, {"CCG", "P"},
                  {"CAU", "H"}, {"CAC", "H"}, {"CAA", "Q"}, {"CAG", "Q"}, {"CGU", "R"}, {"CGC", "R"},
                  {"CGA", "R"}, {"CGG", "R"}, {"AUU", "I"}, {"AUC", "I"}, {"AUA", "I"}, {"AUG", "M"},
                  {"ACU", "T"}, {"ACC", "T"}, {"ACA", "T"}, {"ACG", "T"}, {"AAU", "N"}, {"AAC", "N"},
                  {"AAA", "K"}, {"AAG", "K"}, {"AGU", "S"}, {"AGC", "S"}, {"AGA", "R"}, {"AGG", "R"},
                  {"GUU", "V"}, {"GUC", "V"}, {"GUA", "V"}, {"GUG", "V"}, {"GCU", "A"}, {"GCC", "A"},
                  {"GCA", "A"}, {"GCG", "A"}, {"GAU", "D"}, {"GAC", "D"}, {"GAA", "E"}, {"GAG", "E"},
                  {"GGU", "G"}, {"GGC", "G"}, {"GGA", "G"}, {"GGG", "G"}};

  /**
   * Constructor for DNA that creates a queue from the given string; each node has 1 Character
   *
   * @param sequence the string of DNA to be converted to a queue
   */
  public DNA (String sequence) {
    for (int i = 0; i < sequence.length(); ++i) {
      char dnaQ = sequence.charAt(i);
      DNA.enqueue(dnaQ);
    }
  }

  /**
   * Creates and returns a new queue of mRNA characters from the stored DNA:
   * A->U, T->A, C->G, G->C
   *
   * @return the queue containing the mRNA sequence corresponding to the stored DNA sequence
   */
  public LinkedQueue <Character> transcribeDNA() {

    LinkedQueue <Character> newDNA = new LinkedQueue <> ();

    for (int j = 0; j < DNA.size(); j++) {
      char alphabet = this.DNA.dequeue();

      if (alphabet == 'A') {
        newDNA.enqueue('U');
      }
      else if (alphabet == 'T') {
        newDNA.enqueue('A');
      }
      else if (alphabet == 'G') {
        newDNA.enqueue('C');
      }
      else if (alphabet == 'C') {
        newDNA.enqueue('G');
      }
      
      else {
        System.out.println(("The alphabet is not valid!"));
      }
      this.DNA.enqueue(alphabet);
    }
    return newDNA;
  }

  /**
   * Translates and returns a new queue of amino acids from the transcribeDNA() queue,
   * using the mRNA to protein map
   *
   * @param mRNA the mRNA queue to be translated that corresponds to the stored DNA sequence
   * @return the queue with the amino acid sequence corresponding to the provided mRNA sequence
   */
  public LinkedQueue <String> mRNATranslate(LinkedQueue <Character> mRNA) {

    LinkedQueue <String> aminoQ = new LinkedQueue <>();

    int lpcount = mRNA.size();
    for (int k = 0; k < lpcount; ++k) { //mRNA.size()/3??? mRNAtoProteinMap.length
      String mrnaStr = "";
      // Although k being an int has already eliminated the remainder, I added this just in case
      if (mRNA.size() >= 3) {
        for (int x = 0; x < 3; x++) {
          Character alphabet = mRNA.dequeue();
          mrnaStr += alphabet;
        }

        for (int y = 0; y < (mRNAtoProteinMap.length); y++) {
          if (mRNAtoProteinMap[y][0].equals(mrnaStr)) {
            if (mRNAtoProteinMap[y][1].equals("STOP")) {
              return aminoQ;
            } else {
              aminoQ.enqueue(mRNAtoProteinMap[y][1]);
            }
          }
        }
      }
    }
    return aminoQ;
  }

  /**
   * A shortcut method that translates the stored DNA sequence to a queue of amino acids using
   * the other two methods in this class
   *
   * @return the queue containing the amino acid sequence corresponding to the stored DNA sequence
   */
  public LinkedQueue <String> translateDNA() {

    LinkedQueue <Character> transcriberDNA = transcribeDNA();
    LinkedQueue <String> mRNATranslator = mRNATranslate(transcriberDNA);

    return mRNATranslator;

  }

}