(ns c2.links-spec
  (:require [speclj.core :refer :all]
            [c2.links :refer :all]))

(describe "internal links"
  (it "extracts no links"
    (should= [] (internal "")))
  (it "extracts a single link"
    (should= ["LiskovSubstitutionPrinciple"] (internal "<a href=\"wiki?LiskovSubstitutionPrinciple\">LiskovSubstitutionPrinciple</a>")))
  (it "extracts multiple links"
    (should= ["LiskovSubstitutionPrinciple", "DependencyInversionPrinciple"]
      (internal "<a href=\"wiki?LiskovSubstitutionPrinciple\">LiskovSubstitutionPrinciple</a> Some Junk here
               More here <a href=\"wiki?DependencyInversionPrinciple\">DependencyInversionPrinciple</a> is cool "))
  )
  (it "should ignore edit links"
    (should= [] (internal "<li> Former student of IndustrialDesign<a href=\"wiki?edit=IndustrialDesign\" rel=\"nofollow\">?</a>.  ")))
  )

