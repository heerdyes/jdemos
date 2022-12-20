import java.util.*;

color inp=color(255, 0, 0);

Set<Integer> li;
int cursor=0;
int spacing=60;
color fg=color(0);
color bg=color(255);
StringBuffer numinp;
String retval;

void setup() {
  size(900, 500);
  background(255);
  stroke(0);
  fill(0);
  textSize(40);
  textFont(createFont("Courier", 40));
  textAlign(CENTER, CENTER);
  li=new HashSet<>();
  numinp=new StringBuffer();
  retval="";
}

void rndrset() {
  StringBuffer tmp=new StringBuffer();
  tmp.append("{");
  for (int i : li) {
    String u=String.format("%d,", i);
    tmp.append(u);
  }
  if (li.size()>0) {
    tmp.deleteCharAt(tmp.length()-1);
  }
  tmp.append("}");
  text(tmp.toString(), width/2, height/2);
}

void rndrnuminp() {
  text(numinp.toString(), width-50, 20);
}

void draw() {
  background(255);
  rndrset();
  rndrnuminp();
  text("retval: "+retval, width/3, height-40);
}

void keyPressed() {
  if (keyCode>=48 && keyCode<=57) {
    numinp.append(key);
  } else if (key=='a') {
    li.add(int(random(1, 100)));
  } else if (key=='\n') {
    if (numinp.length()>0) {
      int x=Integer.parseInt(numinp.toString());
      retval = ""+li.add(x);
      numinp.setLength(0);
    }
  } else if (key=='d') {
    if (numinp.length()>0) {
      int x=Integer.parseInt(numinp.toString());
      retval = ""+li.remove(x);
      numinp.setLength(0);
    }
  }
}
