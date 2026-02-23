public interface Visitor {
    void visit(ChildPatient childPatient);
    void visit(AdultPatient adultPatient);
    void visit(OldPatient oldPatient);       
}

class DiagnosisVisitor implements Visitor{
    public void visit(ChildPatient childPatient){
        System.out.println("diag child");
    }
    public void visit(AdultPatient adultPatient){
        System.out.println("diag adult");
    }
    public void visit(OldPatient oldPatient){
        System.out.println("diag old");
    }
}

class BillingVisitor implements Visitor{
    public void visit(ChildPatient childPatient){
        System.out.println("billing child");
    }
    public void visit(AdultPatient adultPatient){
        System.out.println("billing adult");
    }
    public void visit(OldPatient oldPatient){
        System.out.println("billing old");
    }
}

class ReportVisitor implements Visitor{
    public void visit(ChildPatient childPatient){
        System.out.println("report child");
    }
    public void visit(AdultPatient adultPatient){
        System.out.println("repo adukt");
    }
    public void visit(OldPatient oldPatient){
        System.out.println("report old");;
    }
}

interface Patient{
    void accept(Visitor visitor);
}
class ChildPatient implements Patient{
   public void accept(Visitor visitor){
    visitor.visit(this);
   }
}

class AdultPatient implements Patient{
   public void accept(Visitor visitor){
    visitor.visit(this);
   }
}

class OldPatient implements Patient{
   public void accept(Visitor visitor){
    visitor.visit(this);
   }
}

class Main{
    public static void main(String[] args) {
        Patient[] patients={
            new ChildPatient(),new AdultPatient(),new OldPatient()
        };
        Visitor diagVisitor=new DiagnosisVisitor();
        Visitor bVisitor=new BillingVisitor();
        Visitor reVisitor=new ReportVisitor();
        for (Patient pat:patients){
            pat.accept(diagVisitor);
            pat.accept(bVisitor);
            pat.accept(reVisitor);
        }
    }
}