{-# LANGUAGE TemplateHaskell #-}

module SeventyOne where

-- It's actually one through ninetyNine

import BuildNumerals

$(build_numerals)
