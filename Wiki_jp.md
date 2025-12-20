# 再生ブロックの追加方法
このMODにはpresetが用意されており、それぞれに再生速度とブロックがデフォルトで割り当てられています。

再生速度はconfigから設定できます。

ブロックの追加と削除は配布されているDatapackの利用を推奨します。

### 例
preset01にminecraft:dirtを追加したい場合、data/re_ore/tags/blocks/preset01.json内の"value"に minecraft:dirt を追加します。

デフォルトで割り当てられている鉱石を削除したい場合は、jsonファイルに記載されているブロックIDを削除します。

("replace"が"true"になっていることを確認してください)

# ディメンションごとの設定
再生するブロックをディメンションごとに制限することができます。

### 例
仮にDatapackで"test:test_dimension"を追加した場合、data/re_ore/tags/dimension/regen_dimension.json内の"value"に"test:test_dimension"を追加します。

デフォルトで割り当てられているディメンションを削除したい場合、jsonファイルに記載されているディメンションIDを削除します。

("replace"が"true"になっていることを確認してください)
