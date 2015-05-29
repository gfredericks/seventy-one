-- | 

module BuildNumerals where

import Data.Char
import Data.Monoid
import Language.Haskell.TH

oneToNine = words "One Two Three Four Five Six Seven Eight Nine"
zeroToNineEndings = "" : map ("-"<>) oneToNine
oneToNinetyNine = oneToNine
    <> words "Ten Eleven Twelve Thirteen Fourteen Fifteen Sixteen Seventeen Eighteen Nineteen"
    <> [ decade <> ending |
         decade <- words "Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety"
       , ending <- zeroToNineEndings ]

capitalize :: String -> String
capitalize (head:tail) = toUpper head : map toLower tail
capitalize [] = []

split :: (Char -> Bool) -> String -> [String]
split p s = case dropWhile p s of
    "" -> []
    s' -> w : split p s''
          where
            (w, s'') = break p s'

mixedCase :: String -> String
mixedCase w = head splitted ++ (concat capitalized)
  where splitted = split (=='-') w
        capitalized = map capitalize $ tail splitted

genNumeral :: Integer -> Dec
genNumeral n = ValD (VarP (mkName wordVersion)) (NormalB (LitE (IntegerL n))) []
  where wordVersion = mixedCase $ map toLower $ oneToNinetyNine !! (fromInteger (n -  1))

build_numerals :: Q [Dec]
build_numerals = return $ fmap genNumeral [1..99]
