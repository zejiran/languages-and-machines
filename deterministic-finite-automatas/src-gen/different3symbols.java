// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/different3symbols.gold"
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
public final class different3symbols {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=17;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,different3symbols.createAutomaton()));
      $line=18;
      Utilities.test($cast(gold.structures.automaton.IAutomaton.class,different3symbols.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,different3symbols.class,"main",$line);
    }
  }
  public static IAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=24;
      Object Q=$fix($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY($opUnionY(GCollections.asSet('a','b','c','d','e'),$opCartsY(new Object[]{GCollections.asSet('a'),GCollections.asSet('b','c','d','e')})),$opCartsY(new Object[]{GCollections.asSet('b'),GCollections.asSet('a','c','d','e')})),$opCartsY(new Object[]{GCollections.asSet('c'),GCollections.asSet('a','b','d','e')})),$opCartsY(new Object[]{GCollections.asSet('d'),GCollections.asSet('a','b','c','e')})),$opCartsY(new Object[]{GCollections.asSet('e'),GCollections.asSet('a','b','c','d')})),GCollections.asSet('0','1')));
      $line=33;
      Object \u03A3=$fix(GCollections.asSet('a','b','c','d','e'));
      $line=34;
      Object q_0=$fix('0');
      $line=35;
      Object F=$fix(GCollections.asSet('1'));
      $line=36;
      $result=$invokeConstructor(GDeterministicAutomaton.class,new Object[]{Q,\u03A3,q_0,F,new GMethod(different3symbols.class,"d")});
      if (true) break $try;
      $line=37;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,different3symbols.class,"createAutomaton",$line);
    }
    return $cast(IAutomaton.class,$result);
  }
  public static Object d(Object x, Object z) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=40;
      if ($opEqualY(x,'0')) {
        $line=41;
        if ((((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
          $line=41;
          $result=z;
          if (true) break $try;
        }
        else {
          $line=42;
          if ($opEqualY(z,'0')) {
            $line=42;
            $result=z;
            if (true) break $try;
          }
        }
      }
      else {
        $line=45;
        if ($opEqualY(x,'a')) {
          $line=46;
          if (((($opEqualY(z,'b')||$opEqualY(z,'c'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
            $line=46;
            $result=GCollections.asList(x,z);
            if (true) break $try;
          }
          else {
            $line=47;
            $result=x;
            if (true) break $try;
          }
        }
        else {
          $line=49;
          if ($opEqualY(x,'b')) {
            $line=50;
            if (((($opEqualY(z,'a')||$opEqualY(z,'c'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
              $line=50;
              $result=GCollections.asList(x,z);
              if (true) break $try;
            }
            else {
              $line=51;
              $result=x;
              if (true) break $try;
            }
          }
          else {
            $line=53;
            if ($opEqualY(x,'c')) {
              $line=54;
              if (((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
                $line=54;
                $result=GCollections.asList(x,z);
                if (true) break $try;
              }
              else {
                $line=55;
                $result=x;
                if (true) break $try;
              }
            }
            else {
              $line=57;
              if ($opEqualY(x,'d')) {
                $line=58;
                if (((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))||$opEqualY(z,'e'))) {
                  $line=58;
                  $result=GCollections.asList(x,z);
                  if (true) break $try;
                }
                else {
                  $line=59;
                  $result=x;
                  if (true) break $try;
                }
              }
              else {
                $line=61;
                if ($opEqualY(x,'e')) {
                  $line=62;
                  if (((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))||$opEqualY(z,'d'))) {
                    $line=62;
                    $result=GCollections.asList(x,z);
                    if (true) break $try;
                  }
                  else {
                    $line=63;
                    $result=x;
                    if (true) break $try;
                  }
                }
                else {
                  $line=66;
                  $result='1';
                  if (true) break $try;
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
      $rethrow($throwable,different3symbols.class,"d",$line);
    }
    return $result;
  }
  public static Object d(java.lang.Iterable $v1, Object z) {
    int $line=0;
    Object $result=null;
    $try:try {
      java.util.Iterator $v2=GCollections.unmodifiableCollection($v1).iterator();
      Object x=$v2.next();
      Object y=$v2.next();
      $line=71;
      if ($opEqualY(x,'a')) {
        $line=72;
        if ($opEqualY(y,'b')) {
          $line=73;
          if ((($opEqualY(z,'c')||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
            $line=73;
            $result='1';
            if (true) break $try;
          }
          else {
            $line=74;
            $result=GCollections.asList(x,y);
            if (true) break $try;
          }
        }
        else {
          $line=76;
          if ($opEqualY(y,'c')) {
            $line=77;
            if ((($opEqualY(z,'b')||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
              $line=77;
              $result='1';
              if (true) break $try;
            }
            else {
              $line=78;
              $result=GCollections.asList(x,y);
              if (true) break $try;
            }
          }
          else {
            $line=80;
            if ($opEqualY(y,'d')) {
              $line=81;
              if ((($opEqualY(z,'b')||$opEqualY(z,'c'))||$opEqualY(z,'e'))) {
                $line=81;
                $result='1';
                if (true) break $try;
              }
              else {
                $line=82;
                $result=GCollections.asList(x,y);
                if (true) break $try;
              }
            }
            else {
              $line=84;
              if ($opEqualY(y,'e')) {
                $line=85;
                if ((($opEqualY(z,'b')||$opEqualY(z,'c'))||$opEqualY(z,'d'))) {
                  $line=85;
                  $result='1';
                  if (true) break $try;
                }
                else {
                  $line=86;
                  $result=GCollections.asList(x,y);
                  if (true) break $try;
                }
              }
            }
          }
        }
      }
      $line=90;
      if ($opEqualY(x,'b')) {
        $line=91;
        if ($opEqualY(y,'a')) {
          $line=92;
          if ((($opEqualY(z,'c')||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
            $line=92;
            $result='1';
            if (true) break $try;
          }
          else {
            $line=93;
            $result=GCollections.asList(x,y);
            if (true) break $try;
          }
        }
        else {
          $line=95;
          if ($opEqualY(y,'c')) {
            $line=96;
            if ((($opEqualY(z,'a')||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
              $line=96;
              $result='1';
              if (true) break $try;
            }
            else {
              $line=97;
              $result=GCollections.asList(x,y);
              if (true) break $try;
            }
          }
          else {
            $line=99;
            if ($opEqualY(y,'d')) {
              $line=100;
              if ((($opEqualY(z,'a')||$opEqualY(z,'c'))||$opEqualY(z,'e'))) {
                $line=100;
                $result='1';
                if (true) break $try;
              }
              else {
                $line=101;
                $result=GCollections.asList(x,y);
                if (true) break $try;
              }
            }
            else {
              $line=103;
              if ($opEqualY(y,'e')) {
                $line=104;
                if ((($opEqualY(z,'a')||$opEqualY(z,'c'))||$opEqualY(z,'d'))) {
                  $line=104;
                  $result='1';
                  if (true) break $try;
                }
                else {
                  $line=105;
                  $result=GCollections.asList(x,y);
                  if (true) break $try;
                }
              }
            }
          }
        }
      }
      $line=109;
      if ($opEqualY(x,'c')) {
        $line=110;
        if ($opEqualY(y,'a')) {
          $line=111;
          if ((($opEqualY(z,'b')||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
            $line=111;
            $result='1';
            if (true) break $try;
          }
          else {
            $line=112;
            $result=GCollections.asList(x,y);
            if (true) break $try;
          }
        }
        else {
          $line=114;
          if ($opEqualY(y,'b')) {
            $line=115;
            if ((($opEqualY(z,'a')||$opEqualY(z,'d'))||$opEqualY(z,'e'))) {
              $line=115;
              $result='1';
              if (true) break $try;
            }
            else {
              $line=116;
              $result=GCollections.asList(x,y);
              if (true) break $try;
            }
          }
          else {
            $line=118;
            if ($opEqualY(y,'d')) {
              $line=119;
              if ((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'e'))) {
                $line=119;
                $result='1';
                if (true) break $try;
              }
              else {
                $line=120;
                $result=GCollections.asList(x,y);
                if (true) break $try;
              }
            }
            else {
              $line=122;
              if ($opEqualY(y,'e')) {
                $line=123;
                if ((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'d'))) {
                  $line=123;
                  $result='1';
                  if (true) break $try;
                }
                else {
                  $line=124;
                  $result=GCollections.asList(x,y);
                  if (true) break $try;
                }
              }
            }
          }
        }
      }
      $line=128;
      if ($opEqualY(x,'d')) {
        $line=129;
        if ($opEqualY(y,'a')) {
          $line=130;
          if ((($opEqualY(z,'b')||$opEqualY(z,'c'))||$opEqualY(z,'e'))) {
            $line=130;
            $result='1';
            if (true) break $try;
          }
          else {
            $line=131;
            $result=GCollections.asList(x,y);
            if (true) break $try;
          }
        }
        else {
          $line=133;
          if ($opEqualY(y,'b')) {
            $line=134;
            if ((($opEqualY(z,'a')||$opEqualY(z,'c'))||$opEqualY(z,'e'))) {
              $line=134;
              $result='1';
              if (true) break $try;
            }
            else {
              $line=135;
              $result=GCollections.asList(x,y);
              if (true) break $try;
            }
          }
          else {
            $line=137;
            if ($opEqualY(y,'c')) {
              $line=138;
              if ((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'e'))) {
                $line=138;
                $result='1';
                if (true) break $try;
              }
              else {
                $line=139;
                $result=GCollections.asList(x,y);
                if (true) break $try;
              }
            }
            else {
              $line=141;
              if ($opEqualY(y,'e')) {
                $line=142;
                if ((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))) {
                  $line=142;
                  $result='1';
                  if (true) break $try;
                }
                else {
                  $line=143;
                  $result=GCollections.asList(x,y);
                  if (true) break $try;
                }
              }
            }
          }
        }
      }
      $line=147;
      if ($opEqualY(x,'e')) {
        $line=148;
        if ($opEqualY(y,'a')) {
          $line=149;
          if ((($opEqualY(z,'b')||$opEqualY(z,'c'))||$opEqualY(z,'d'))) {
            $line=149;
            $result='1';
            if (true) break $try;
          }
          else {
            $line=150;
            $result=GCollections.asList(x,y);
            if (true) break $try;
          }
        }
        else {
          $line=152;
          if ($opEqualY(y,'b')) {
            $line=153;
            if ((($opEqualY(z,'a')||$opEqualY(z,'c'))||$opEqualY(z,'d'))) {
              $line=153;
              $result='1';
              if (true) break $try;
            }
            else {
              $line=154;
              $result=GCollections.asList(x,y);
              if (true) break $try;
            }
          }
          else {
            $line=156;
            if ($opEqualY(y,'c')) {
              $line=157;
              if ((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'d'))) {
                $line=157;
                $result='1';
                if (true) break $try;
              }
              else {
                $line=158;
                $result=GCollections.asList(x,y);
                if (true) break $try;
              }
            }
            else {
              $line=160;
              if ($opEqualY(y,'d')) {
                $line=161;
                if ((($opEqualY(z,'a')||$opEqualY(z,'b'))||$opEqualY(z,'c'))) {
                  $line=161;
                  $result='1';
                  if (true) break $try;
                }
                else {
                  $line=162;
                  $result=GCollections.asList(x,y);
                  if (true) break $try;
                }
              }
            }
          }
        }
      }
      $line=166;
      $rethrow(new RuntimeException("The function \"d(\u27E8x,y\u27E9:java.lang.Iterable,z:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,different3symbols.class,"d",$line);
    }
    return $result;
  }
}
