ArrayList<Integer> li;
int cursor=0;
int spacing=80;
color fg=color(0);
color bg=color(255);
StringBuffer sb;
color ptr=color(255, 0, 0);

void setup() {
  size(900, 400);
  background(255);
  stroke(0);
  fill(0);
  textSize(50);
  textFont(createFont("Courier", 50));
  textAlign(CENTER, CENTER);
  li=new ArrayList<>();
  sb=new StringBuffer();
}

void rndrlist() {
  int offset=50;
  stroke(fg);
  fill(fg);
  text("[", offset, height/2);
  offset+=spacing;
  for (int i=0; i<li.size(); i++) {
    text(String.format("%02d", li.get(i)), offset, height/2);
    offset+=spacing;
  }
  text("]", offset, height/2);
}

void rndrptr() {
  int offset=spacing+spacing/4, i;
  for (i=0; i<cursor; i++, offset+=spacing);
  stroke(ptr);
  fill(ptr);
  text("^", offset, height/2+30);
}

void draw() {
  background(255);
  rndrlist();
  rndrptr();
  text(sb.toString(), width-50, 20);
}

void keyPressed() {
  if (key=='a') {
    li.add(int(random(1, 100)));
    if (cursor==li.size()-1) {
      cursor++;
    }
  } else if (keyCode==39) {
    if (cursor<li.size()) {
      cursor++;
    }
  } else if (keyCode==37) {
    if (cursor>0) {
      cursor--;
    }
  } else if (key=='i') {
    li.add(cursor++, int(random(1, 100)));
  } else if (keyCode>=48 && keyCode<=57) {
    sb.append(key);
  } else if (key=='\n') {
    li.add(cursor++, Integer.parseInt(sb.toString()));
    sb.setLength(0);
  } else if (key=='d') {
    li.remove(cursor);
  }
}
