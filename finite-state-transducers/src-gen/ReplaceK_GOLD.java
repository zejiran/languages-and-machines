// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/ReplaceK_GOLD.gold"
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
public final class ReplaceK_GOLD {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=3;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,ReplaceK_GOLD.createAutomaton()));
      $line=4;
      Utilities.test($cast(gold.structures.automaton.IAutomaton.class,ReplaceK_GOLD.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,"main",$line);
    }
  }
  public static Object getName() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=8;
      $result="Has cat";
      if (true) break $try;
      $line=9;
      $rethrow(new RuntimeException("The function \"getName()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,"getName",$line);
    }
    return $result;
  }
  public static GHashTableMap delta=null;
  static {
    int $line=0;
    $line=11;
    $try:try {
      delta=$invokeConstructor(GHashTableMap.class,new Object[]{});
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,null,$line);
    }
  }
  public static GHashTableMap outputT=null;
  static {
    int $line=0;
    $line=12;
    $try:try {
      outputT=$invokeConstructor(GHashTableMap.class,new Object[]{});
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,null,$line);
    }
  }
  public static IAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=15;
      Object Q=$fix(GCollections.asSet("_cat","c_at","ca_t","fin",0));
      $line=16;
      Object O=$fix(GCollections.asSet('c','a','t','$'));
      $line=17;
      Object \u03A3=$fix(GCollections.asSet('c','a','t','K','$'));
      $line=19;
      Object q_0=$fix("_cat");
      $line=20;
      Object F=$fix(GCollections.asSet("fin"));
      $line=25;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("_cat",'c'),"c");
      $line=26;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("_cat",'$'),"$");
      $line=27;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("_cat",'a'),"a");
      $line=28;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("_cat",'t'),"t");
      $line=29;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("_cat",'K'),"cat");
      $line=32;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("c_at",'c'),"c");
      $line=33;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("c_at",'a'),"a");
      $line=34;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("c_at",'$'),"$");
      $line=35;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("c_at",'t'),"t");
      $line=36;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("c_at",'K'),"cat");
      $line=38;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("ca_t",'c'),"c");
      $line=39;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("ca_t",'$'),"$");
      $line=40;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("ca_t",'a'),"a");
      $line=41;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("ca_t",'t'),"");
      $line=42;
      ((gold.structures.map.GHashTableMap)outputT).put(GCollections.asList("ca_t",'K'),"cat");
      $line=44;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("_cat",'c'),"c_at");
      $line=45;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("_cat",'a'),"_cat");
      $line=46;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("_cat",'t'),"_cat");
      $line=47;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("_cat",'K'),"_cat");
      $line=48;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("_cat",'$'),"fin");
      $line=50;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("c_at",'$'),"fin");
      $line=51;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("c_at",'c'),"c_at");
      $line=52;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("c_at",'a'),"ca_t");
      $line=53;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("c_at",'t'),"_cat");
      $line=54;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("c_at",'K'),"_cat");
      $line=56;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("ca_t",'c'),"c_at");
      $line=57;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("ca_t",'a'),"_cat");
      $line=58;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("ca_t",'K'),"_cat");
      $line=59;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("ca_t",'t'),0);
      $line=60;
      ((gold.structures.map.GHashTableMap)delta).put(GCollections.asList("ca_t",'$'),"fin");
      $line=63;
      $result=$invokeConstructor(GDeterministicTransducer.class,new Object[]{Q,\u03A3,O,"_cat",F,new GMethod(ReplaceK_GOLD.class,"\u03B4"),new GMethod(ReplaceK_GOLD.class,"g"),new GMethod(ReplaceK_GOLD.class,"h")});
      if (true) break $try;
      $line=64;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,"createAutomaton",$line);
    }
    return $cast(IAutomaton.class,$result);
  }
  public static Object g(Object x) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result="";
      if (true) break $try;
      $line=66;
      $rethrow(new RuntimeException("The function \"g(x:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,"g",$line);
    }
    return $result;
  }
  public static Object \u03B4(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result=(($bool(((gold.structures.map.GHashTableMap)delta).containsKey(GCollections.asList(q,s))))?(((gold.structures.map.GHashTableMap)delta).get(GCollections.asList(q,s))):(0));
      if (true) break $try;
      $line=68;
      $rethrow(new RuntimeException("The function \"\u03B4(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,"\u03B4",$line);
    }
    return $result;
  }
  public static Object h(Object q, Object s) {
    int $line=0;
    Object $result=null;
    $try:try {
      $result=(($bool(((gold.structures.map.GHashTableMap)outputT).containsKey(GCollections.asList(q,s))))?(((gold.structures.map.GHashTableMap)outputT).get(GCollections.asList(q,s))):(""));
      if (true) break $try;
      $line=69;
      $rethrow(new RuntimeException("The function \"h(q:Object,s:Object)\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,ReplaceK_GOLD.class,"h",$line);
    }
    return $result;
  }
}
