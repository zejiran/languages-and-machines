// DO NOT EDIT THIS FILE! IT IS AUTOMATICALLY GENERATED FROM FILE "src/CountCatsWrong.gold"
import gold.structures.automaton.*;
import gold.util.*;
import gold.visualization.automaton.*;
import java.lang.*;
import org.apfloat.*;
import static gold.util.GReflection.*;
@SuppressWarnings("all")
public final class CountCatsWrong {
  static {
    gold.swing.util.GUtilities.installGoldLookAndFeel();
  }
  public static void main(String[] args) {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=16;
      GAutomataFrame.show($cast(gold.structures.automaton.IAutomaton.class,CountCatsWrong.createAutomaton()));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,CountCatsWrong.class,"main",$line);
    }
  }
  public static IPushdownAutomaton createAutomaton() {
    int $line=0;
    Object $result=null;
    $try:try {
      $line=19;
      Object \u03A3=$fix(GCollections.asSet('c','a','t','1'));
      $line=21;
      Object Q=$fix(GCollections.asSet(0,1));
      $line=24;
      Object \u0393=$fix(GCollections.asSet('1'));
      $line=25;
      Object q_0=$fix(0);
      $line=26;
      Object F=$fix(GCollections.asSet(1));
      $line=27;
      Object M=$fix($invokeConstructor(GPushdownAutomaton.class,new Object[]{Q,\u03A3,\u0393,q_0,F}));
      $line=29;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(0,0,$cast(java.lang.String.class,'a')),new Object[]{});
      $line=30;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(0,0,$cast(java.lang.String.class,'c')),new Object[]{});
      $line=31;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(0,0,$cast(java.lang.String.class,'t')),new Object[]{});
      $line=32;
      $invokeMethod("push",((gold.structures.automaton.GPushdownAutomaton)M).delta(0,0,$cast(java.lang.String.class,"cat")),new Object[]{"1"});
      $line=33;
      $invokeMethod("pop",((gold.structures.automaton.GPushdownAutomaton)M).delta(1,1,$cast(java.lang.String.class,"1")),new Object[]{"1"});
      $line=35;
      $invokeMethod("ignore",((gold.structures.automaton.GPushdownAutomaton)M).delta(0,1,$cast(java.lang.String.class,"")),new Object[]{});
      $line=38;
      $result=M;
      if (true) break $try;
      $line=39;
      $rethrow(new RuntimeException("The function \"createAutomaton()\" did not return a value."));
    }
    catch (Throwable $throwable) {
      $rethrow($throwable,CountCatsWrong.class,"createAutomaton",$line);
    }
    return $cast(IPushdownAutomaton.class,$result);
  }
}