// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/halvesWithDifferent3symbols.gold"
import gold.*;
import gold.structures.*;
import gold.structures.automaton.*;
import gold.structures.bag.*;
import gold.structures.collection.*;
import gold.structures.deque.*;
import gold.structures.disjointset.*;
import gold.structures.graph.*;
import gold.structures.heap.*;
import gold.structures.list.*;
import gold.structures.map.*;
import gold.structures.multimap.*;
import gold.structures.point.*;
import gold.structures.queue.*;
import gold.structures.set.*;
import gold.structures.stack.*;
import gold.structures.tree.*;
import gold.structures.tree.binary.*;
import gold.structures.tree.nary.*;
import gold.structures.tuple.*;
import gold.structures.turingMachine.*;
import gold.swing.*;
import gold.swing.icon.*;
import gold.swing.icon.ajaxload.*;
import gold.swing.icon.famfamfam.*;
import gold.swing.icon.gold.*;
import gold.swing.icon.jlfgr.*;
import gold.swing.icon.wikimedia.*;
import gold.swing.icon.windows.*;
import gold.swing.look.*;
import gold.swing.util.*;
import gold.test.*;
import gold.test.automaton.*;
import gold.test.general.*;
import gold.test.graph.*;
import gold.util.*;
import gold.visualization.*;
import gold.visualization.automaton.*;
import gold.visualization.graph.*;
import gold.visualization.quadtree.*;
import gold.visualization.turingMachine.*;
import gold.visualization.util.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class halvesWithDifferent3symbols {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=17;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,halvesWithDifferent3symbols.createAutomaton()));
      $line=18;
      Utilities.test($cast(gold.structures.automaton.IAutomaton.class,halvesWithDifferent3symbols.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,halvesWithDifferent3symbols.class,"main",$line);
    }
  }
  public static IAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=22;
      Object Q=$fix($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY(GCollections.asSet('a','b','c','d','e'),$opCartsY(new Object[]{GCollections.asSet('0'),GCollections.asSet('a'),GCollections.asSet('b','c','d','e')})),$opCartsY(new Object[]{GCollections.asSet('0'),GCollections.asSet('b'),GCollections.asSet('a','c','d','e')})),$opCartsY(new Object[]{GCollections.asSet('0'),GCollections.asSet('c'),GCollections.asSet('a','b','d','e')})),$opCartsY(new Object[]{GCollections.asSet('0'),GCollections.asSet('d'),GCollections.asSet('a','b','c','e')})),$opCartsY(new Object[]{GCollections.asSet('0'),GCollections.asSet('e'),GCollections.asSet('a','b','c','d')})),$opCartsY(new Object[]{GCollections.asSet('$','1'),GCollections.asSet('a','1'),GCollections.asSet('b','c','d','e','1')})),$opCartsY(new Object[]{GCollections.asSet('$','1'),GCollections.asSet('b','1'),GCollections.asSet('a','c','d','e','1')})),$opCartsY(new Object[]{GCollections.asSet('$','1'),GCollections.asSet('c','1'),GCollections.asSet('a','b','d','e','1')})),$opCartsY(new Object[]{GCollections.asSet('$','1'),GCollections.asSet('d','1'),GCollections.asSet('a','b','c','e','1')})),$opCartsY(new Object[]{GCollections.asSet('$','1'),GCollections.asSet('e','1'),GCollections.asSet('a','b','c','d','1')})),GCollections.asSet('0',GCollections.asList('1','1','1'))));
      $line=34;
      Object \u03A3=$fix(GCollections.asSet('a','b','c','d','e','$'));
      $line=35;
      Object q_0=$fix('0');
      $line=36;
      Object F=$fix(GCollections.asSet(GCollections.asList('1','1','1')));
      $line=37;
      $result=$invokeConstructor(GDeterministicAutomaton.class,new Object[]{Q,\u03A3,q_0,F,new GMethod(halvesWithDifferent3symbols.class,"d")});
      if (true) break $try;
      $line=38;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,halvesWithDifferent3symbols.class,"createAutomaton",$line);
    }
    return $cast(IAutomaton.class,$result);
  }
  public static Object d(Object x, Object z) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=41;
      if ($opEqualY(x,'0')) {
        $line=42;
        if ((((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
          $line=42;
          $result=z;
          if (true) break $try;
        }
        else {
          $line=43;
          if ($opEqualY(z,'0')) {
            $line=43;
            $result=z;
            if (true) break $try;
          }
          else {
            $line=44;
            if ($opEqualY(z,'$')) {
              $line=44;
              $result='0';
              if (true) break $try;
            }
          }
        }
      }
      else {
        $line=47;
        if ($opEqualY(x,'a')) {
          $line=48;
          if (((($opEqualY(z,'b')||$opEqualY(z,'c'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
            $line=48;
            $result=GCollections.asList('0',x,z);
            if (true) break $try;
          }
          else {
            $line=49;
            $result=x;
            if (true) break $try;
          }
        }
        else {
          $line=51;
          if ($opEqualY(x,'b')) {
            $line=52;
            if (((($opEqualY(z,'a')||$opEqualY(z,'c'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
              $line=52;
              $result=GCollections.asList('0',x,z);
              if (true) break $try;
            }
            else {
              $line=53;
              $result=x;
              if (true) break $try;
            }
          }
          else {
            $line=55;
            if ($opEqualY(x,'c')) {
              $line=56;
              if (((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
                $line=56;
                $result=GCollections.asList('0',x,z);
                if (true) break $try;
              }
              else {
                $line=57;
                $result=x;
                if (true) break $try;
              }
            }
            else {
              $line=59;
              if ($opEqualY(x,'d')) {
                $line=60;
                if (((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))||$opEqualY(z,'e'))) {
                  $line=60;
                  $result=GCollections.asList('0',x,z);
                  if (true) break $try;
                }
                else {
                  $line=61;
                  $result=x;
                  if (true) break $try;
                }
              }
              else {
                $line=63;
                if ($opEqualY(x,'e')) {
                  $line=64;
                  if (((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))||$opEqualY(z,'d'))) {
                    $line=64;
                    $result=GCollections.asList('0',x,z);
                    if (true) break $try;
                  }
                  else {
                    $line=65;
                    $result=x;
                    if (true) break $try;
                  }
                }
              }
            }
          }
        }
      }
      $line=68;
      $rethrow(new RuntimeException("The function \"d(x:Object,z:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,halvesWithDifferent3symbols.class,"d",$line);
    }
    return $result;
  }
  public static Object d(java.lang.Iterable $v1, Object z) {
    int $line=0;
    Object $result=null;
    $try:try {
      java.util.Iterator $v2=GCollections.unmodifiableCollection($v1).iterator();
      Object w=$v2.next();
      Object x=$v2.next();
      Object y=$v2.next();
      $line=71;
      if (($opEqualY(w,'$')||$opEqualY(w,'1'))) {
        $line=72;
        if ($opEqualY(w,z)) {
          $line=72;
          $result=GCollections.asList('1',x,y);
          if (true) break $try;
        }
        else {
          $line=73;
          if ($opEqualY(x,z)) {
            $line=73;
            $result=GCollections.asList(w,'1',y);
            if (true) break $try;
          }
          else {
            $line=74;
            if ($opEqualY(y,z)) {
              $line=74;
              $result=GCollections.asList(w,x,'1');
              if (true) break $try;
            }
            else {
              $line=75;
              $result=GCollections.asList(w,x,y);
              if (true) break $try;
            }
          }
        }
      }
      $line=78;
      if ($opEqualY(x,'a')) {
        $line=79;
        if ($opEqualY(y,'b')) {
          $line=80;
          if ($opEqualY(z,'c')) {
            $line=80;
            $result=GCollections.asList('$','d','e');
            if (true) break $try;
          }
          else {
            $line=81;
            if ($opEqualY(z,'d')) {
              $line=81;
              $result=GCollections.asList('$','c','e');
              if (true) break $try;
            }
            else {
              $line=82;
              if ($opEqualY(z,'e')) {
                $line=82;
                $result=GCollections.asList('$','c','d');
                if (true) break $try;
              }
              else {
                $line=83;
                $result=GCollections.asList(w,x,y);
                if (true) break $try;
              }
            }
          }
        }
        else {
          $line=85;
          if ($opEqualY(y,'c')) {
            $line=86;
            if ($opEqualY(z,'b')) {
              $line=86;
              $result=GCollections.asList('$','d','e');
              if (true) break $try;
            }
            else {
              $line=87;
              if ($opEqualY(z,'d')) {
                $line=87;
                $result=GCollections.asList('$','b','e');
                if (true) break $try;
              }
              else {
                $line=88;
                if ($opEqualY(z,'e')) {
                  $line=88;
                  $result=GCollections.asList('$','b','d');
                  if (true) break $try;
                }
                else {
                  $line=89;
                  $result=GCollections.asList(w,x,y);
                  if (true) break $try;
                }
              }
            }
          }
          else {
            $line=91;
            if ($opEqualY(y,'d')) {
              $line=92;
              if ($opEqualY(z,'b')) {
                $line=92;
                $result=GCollections.asList('$','c','e');
                if (true) break $try;
              }
              else {
                $line=93;
                if ($opEqualY(z,'c')) {
                  $line=93;
                  $result=GCollections.asList('$','b','e');
                  if (true) break $try;
                }
                else {
                  $line=94;
                  if ($opEqualY(z,'e')) {
                    $line=94;
                    $result=GCollections.asList('$','b','c');
                    if (true) break $try;
                  }
                  else {
                    $line=95;
                    $result=GCollections.asList(w,x,y);
                    if (true) break $try;
                  }
                }
              }
            }
            else {
              $line=97;
              if ($opEqualY(y,'e')) {
                $line=98;
                if ($opEqualY(z,'b')) {
                  $line=98;
                  $result=GCollections.asList('$','c','d');
                  if (true) break $try;
                }
                else {
                  $line=99;
                  if ($opEqualY(z,'c')) {
                    $line=99;
                    $result=GCollections.asList('$','b','d');
                    if (true) break $try;
                  }
                  else {
                    $line=100;
                    if ($opEqualY(z,'d')) {
                      $line=100;
                      $result=GCollections.asList('$','b','c');
                      if (true) break $try;
                    }
                    else {
                      $line=101;
                      $result=GCollections.asList(w,x,y);
                      if (true) break $try;
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=105;
      if ($opEqualY(x,'b')) {
        $line=106;
        if ($opEqualY(y,'a')) {
          $line=107;
          if ($opEqualY(z,'c')) {
            $line=107;
            $result=GCollections.asList('$','d','e');
            if (true) break $try;
          }
          else {
            $line=108;
            if ($opEqualY(z,'d')) {
              $line=108;
              $result=GCollections.asList('$','c','e');
              if (true) break $try;
            }
            else {
              $line=109;
              if ($opEqualY(z,'e')) {
                $line=109;
                $result=GCollections.asList('$','c','d');
                if (true) break $try;
              }
              else {
                $line=110;
                $result=GCollections.asList(w,x,y);
                if (true) break $try;
              }
            }
          }
        }
        else {
          $line=112;
          if ($opEqualY(y,'c')) {
            $line=113;
            if ($opEqualY(z,'a')) {
              $line=113;
              $result=GCollections.asList('$','d','e');
              if (true) break $try;
            }
            else {
              $line=114;
              if ($opEqualY(z,'d')) {
                $line=114;
                $result=GCollections.asList('$','a','e');
                if (true) break $try;
              }
              else {
                $line=115;
                if ($opEqualY(z,'e')) {
                  $line=115;
                  $result=GCollections.asList('$','a','d');
                  if (true) break $try;
                }
                else {
                  $line=116;
                  $result=GCollections.asList(w,x,y);
                  if (true) break $try;
                }
              }
            }
          }
          else {
            $line=118;
            if ($opEqualY(y,'d')) {
              $line=119;
              if ($opEqualY(z,'a')) {
                $line=119;
                $result=GCollections.asList('$','c','e');
                if (true) break $try;
              }
              else {
                $line=120;
                if ($opEqualY(z,'c')) {
                  $line=120;
                  $result=GCollections.asList('$','a','e');
                  if (true) break $try;
                }
                else {
                  $line=121;
                  if ($opEqualY(z,'e')) {
                    $line=121;
                    $result=GCollections.asList('$','a','c');
                    if (true) break $try;
                  }
                  else {
                    $line=122;
                    $result=GCollections.asList(w,x,y);
                    if (true) break $try;
                  }
                }
              }
            }
            else {
              $line=124;
              if ($opEqualY(y,'e')) {
                $line=125;
                if ($opEqualY(z,'a')) {
                  $line=125;
                  $result=GCollections.asList('$','c','d');
                  if (true) break $try;
                }
                else {
                  $line=126;
                  if ($opEqualY(z,'c')) {
                    $line=126;
                    $result=GCollections.asList('$','a','d');
                    if (true) break $try;
                  }
                  else {
                    $line=127;
                    if ($opEqualY(z,'d')) {
                      $line=127;
                      $result=GCollections.asList('$','a','c');
                      if (true) break $try;
                    }
                    else {
                      $line=128;
                      $result=GCollections.asList(w,x,y);
                      if (true) break $try;
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=132;
      if ($opEqualY(x,'c')) {
        $line=133;
        if ($opEqualY(y,'b')) {
          $line=134;
          if ($opEqualY(z,'a')) {
            $line=134;
            $result=GCollections.asList('$','d','e');
            if (true) break $try;
          }
          else {
            $line=135;
            if ($opEqualY(z,'d')) {
              $line=135;
              $result=GCollections.asList('$','a','e');
              if (true) break $try;
            }
            else {
              $line=136;
              if ($opEqualY(z,'e')) {
                $line=136;
                $result=GCollections.asList('$','a','d');
                if (true) break $try;
              }
              else {
                $line=137;
                $result=GCollections.asList(w,x,y);
                if (true) break $try;
              }
            }
          }
        }
        else {
          $line=139;
          if ($opEqualY(y,'a')) {
            $line=140;
            if ($opEqualY(z,'b')) {
              $line=140;
              $result=GCollections.asList('$','d','e');
              if (true) break $try;
            }
            else {
              $line=141;
              if ($opEqualY(z,'d')) {
                $line=141;
                $result=GCollections.asList('$','b','e');
                if (true) break $try;
              }
              else {
                $line=142;
                if ($opEqualY(z,'e')) {
                  $line=142;
                  $result=GCollections.asList('$','b','d');
                  if (true) break $try;
                }
                else {
                  $line=143;
                  $result=GCollections.asList(w,x,y);
                  if (true) break $try;
                }
              }
            }
          }
          else {
            $line=145;
            if ($opEqualY(y,'d')) {
              $line=146;
              if ($opEqualY(z,'b')) {
                $line=146;
                $result=GCollections.asList('$','a','e');
                if (true) break $try;
              }
              else {
                $line=147;
                if ($opEqualY(z,'a')) {
                  $line=147;
                  $result=GCollections.asList('$','b','e');
                  if (true) break $try;
                }
                else {
                  $line=148;
                  if ($opEqualY(z,'e')) {
                    $line=148;
                    $result=GCollections.asList('$','a','b');
                    if (true) break $try;
                  }
                  else {
                    $line=149;
                    $result=GCollections.asList(w,x,y);
                    if (true) break $try;
                  }
                }
              }
            }
            else {
              $line=151;
              if ($opEqualY(y,'e')) {
                $line=152;
                if ($opEqualY(z,'b')) {
                  $line=152;
                  $result=GCollections.asList('$','a','d');
                  if (true) break $try;
                }
                else {
                  $line=153;
                  if ($opEqualY(z,'a')) {
                    $line=153;
                    $result=GCollections.asList('$','b','d');
                    if (true) break $try;
                  }
                  else {
                    $line=154;
                    if ($opEqualY(z,'d')) {
                      $line=154;
                      $result=GCollections.asList('$','a','b');
                      if (true) break $try;
                    }
                    else {
                      $line=155;
                      $result=GCollections.asList(w,x,y);
                      if (true) break $try;
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=159;
      if ($opEqualY(x,'d')) {
        $line=160;
        if ($opEqualY(y,'b')) {
          $line=161;
          if ($opEqualY(z,'c')) {
            $line=161;
            $result=GCollections.asList('$','a','e');
            if (true) break $try;
          }
          else {
            $line=162;
            if ($opEqualY(z,'a')) {
              $line=162;
              $result=GCollections.asList('$','c','e');
              if (true) break $try;
            }
            else {
              $line=163;
              if ($opEqualY(z,'e')) {
                $line=163;
                $result=GCollections.asList('$','a','c');
                if (true) break $try;
              }
              else {
                $line=164;
                $result=GCollections.asList(w,x,y);
                if (true) break $try;
              }
            }
          }
        }
        else {
          $line=166;
          if ($opEqualY(y,'c')) {
            $line=167;
            if ($opEqualY(z,'b')) {
              $line=167;
              $result=GCollections.asList('$','a','e');
              if (true) break $try;
            }
            else {
              $line=168;
              if ($opEqualY(z,'a')) {
                $line=168;
                $result=GCollections.asList('$','b','e');
                if (true) break $try;
              }
              else {
                $line=169;
                if ($opEqualY(z,'e')) {
                  $line=169;
                  $result=GCollections.asList('$','a','b');
                  if (true) break $try;
                }
                else {
                  $line=170;
                  $result=GCollections.asList(w,x,y);
                  if (true) break $try;
                }
              }
            }
          }
          else {
            $line=172;
            if ($opEqualY(y,'a')) {
              $line=173;
              if ($opEqualY(z,'b')) {
                $line=173;
                $result=GCollections.asList('$','c','e');
                if (true) break $try;
              }
              else {
                $line=174;
                if ($opEqualY(z,'c')) {
                  $line=174;
                  $result=GCollections.asList('$','b','e');
                  if (true) break $try;
                }
                else {
                  $line=175;
                  if ($opEqualY(z,'e')) {
                    $line=175;
                    $result=GCollections.asList('$','b','c');
                    if (true) break $try;
                  }
                  else {
                    $line=176;
                    $result=GCollections.asList(w,x,y);
                    if (true) break $try;
                  }
                }
              }
            }
            else {
              $line=178;
              if ($opEqualY(y,'e')) {
                $line=179;
                if ($opEqualY(z,'b')) {
                  $line=179;
                  $result=GCollections.asList('$','a','c');
                  if (true) break $try;
                }
                else {
                  $line=180;
                  if ($opEqualY(z,'c')) {
                    $line=180;
                    $result=GCollections.asList('$','a','b');
                    if (true) break $try;
                  }
                  else {
                    $line=181;
                    if ($opEqualY(z,'a')) {
                      $line=181;
                      $result=GCollections.asList('$','b','c');
                      if (true) break $try;
                    }
                    else {
                      $line=182;
                      $result=GCollections.asList(w,x,y);
                      if (true) break $try;
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=186;
      if ($opEqualY(x,'e')) {
        $line=187;
        if ($opEqualY(y,'b')) {
          $line=188;
          if ($opEqualY(z,'c')) {
            $line=188;
            $result=GCollections.asList('$','a','d');
            if (true) break $try;
          }
          else {
            $line=189;
            if ($opEqualY(z,'d')) {
              $line=189;
              $result=GCollections.asList('$','a','c');
              if (true) break $try;
            }
            else {
              $line=190;
              if ($opEqualY(z,'a')) {
                $line=190;
                $result=GCollections.asList('$','c','d');
                if (true) break $try;
              }
              else {
                $line=191;
                $result=GCollections.asList(w,x,y);
                if (true) break $try;
              }
            }
          }
        }
        else {
          $line=193;
          if ($opEqualY(y,'c')) {
            $line=194;
            if ($opEqualY(z,'b')) {
              $line=194;
              $result=GCollections.asList('$','a','d');
              if (true) break $try;
            }
            else {
              $line=195;
              if ($opEqualY(z,'d')) {
                $line=195;
                $result=GCollections.asList('$','a','b');
                if (true) break $try;
              }
              else {
                $line=196;
                if ($opEqualY(z,'a')) {
                  $line=196;
                  $result=GCollections.asList('$','b','d');
                  if (true) break $try;
                }
                else {
                  $line=197;
                  $result=GCollections.asList(w,x,y);
                  if (true) break $try;
                }
              }
            }
          }
          else {
            $line=199;
            if ($opEqualY(y,'d')) {
              $line=200;
              if ($opEqualY(z,'b')) {
                $line=200;
                $result=GCollections.asList('$','a','c');
                if (true) break $try;
              }
              else {
                $line=201;
                if ($opEqualY(z,'c')) {
                  $line=201;
                  $result=GCollections.asList('$','a','b');
                  if (true) break $try;
                }
                else {
                  $line=202;
                  if ($opEqualY(z,'a')) {
                    $line=202;
                    $result=GCollections.asList('$','b','c');
                    if (true) break $try;
                  }
                  else {
                    $line=203;
                    $result=GCollections.asList(w,x,y);
                    if (true) break $try;
                  }
                }
              }
            }
            else {
              $line=205;
              if ($opEqualY(y,'a')) {
                $line=206;
                if ($opEqualY(z,'b')) {
                  $line=206;
                  $result=GCollections.asList('$','c','d');
                  if (true) break $try;
                }
                else {
                  $line=207;
                  if ($opEqualY(z,'c')) {
                    $line=207;
                    $result=GCollections.asList('$','b','d');
                    if (true) break $try;
                  }
                  else {
                    $line=208;
                    if ($opEqualY(z,'d')) {
                      $line=208;
                      $result=GCollections.asList('$','b','c');
                      if (true) break $try;
                    }
                    else {
                      $line=209;
                      $result=GCollections.asList(w,x,y);
                      if (true) break $try;
                    }
                  }
                }
              }
            }
          }
        }
      }
      $line=213;
      $rethrow(new RuntimeException("The function \"d(\u27E8w,x,y\u27E9:java.lang.Iterable,z:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,halvesWithDifferent3symbols.class,"d",$line);
    }
    return $result;
  }
}
