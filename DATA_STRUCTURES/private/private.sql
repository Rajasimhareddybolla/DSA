-- The first number in the triplet is the sentence number referenced by the encoder.
-- The second number in the triplet is the character number, within that sentence, at which the message begins.
-- The third number in the triplet is the message length in characters (i.e., how many characters to read from the first, including spaces and punctuation).
create table "secrete"(
  sentence ,
  First_char,
  Length);
INSERT INTO secrete (sentence,First_char , Length) values (14,98,4);
INSERT INTO secrete (sentence,First_char , Length) values (114,3,5);
INSERT INTO secrete (sentence,First_char , Length) values (618,72,9);
INSERT INTO secrete (sentence,First_char , Length) values (630,7,3);
INSERT INTO secrete (sentence,First_char , Length) values (932,12,5);
INSERT INTO secrete (sentence,First_char , Length) values (2230,50,7);
INSERT INTO secrete (sentence,First_char , Length) values (2346,44,10);
INSERT INTO secrete (sentence,First_char , Length) values (3041,14,5);


CREATE VIEW "message" AS    
    SELECT substr(sentences.sentence,secrete.First_char,secrete.Length) AS "phrase" FROM sentences join secrete on sentences.id = secrete.sentence;
