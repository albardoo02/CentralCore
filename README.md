# CentralCore
## 概要
マインクラフトサーバの拡張機能プラグイン

## 導入
1：Releasesから最新のjarファイルをダウンロード

2：サーバーのpluginsフォルダに入れる

3：Plugmanを利用してロードするか、サーバーを再起動する。

4：CentralCoreフォルダ内にあるconfig.ymlを設定する。

5：`/cc reload`でConfigを再読み込みするか、サーバーを再起動する。

## 連携プラグイン
・[Vault](https://www.spigotmc.org/resources/vault.34315/)

・Economyプラグイン ([EssentialsX等](https://www.spigotmc.org/resources/essentialsx.9089/))

## コマンド
### 全般
`/cc help`: CentralCoreのヘルプ

`/cc reload`: Configの再読み込み

`/cc version`: バージョンの表示

### CentralCoreコマンド
`/cc get <アイテム名>`：登録されたアイテムの入手

Ex) `/cc get tool2`: アイテムID確認棒

エイリアス: `/centralcore, /core , /central , //cc`

### Wikiコマンド
`/wiki`: WikiのURLの表示

`/wiki <設定名>`: 設定された名前のURLを表示します。

### SetWikiコマンド
`/setwiki set <url>`: /wikiで表示されるURLの設定

`/setwiki add <設定名> <URL>`: 設定名付きのURLの設定

エイリアス：`/ewiki, /editwiki, /settingwiki`

### Wearコマンド
`/wear <helmet|chestplate|leggings|boots>`: 引数で指定された所に装備する

エイリアス: `/equip`

## 権限 / Permission
### 全般
- `CentralCore.*`: CentralCoreの全権限

### CentralCoreコマンド
- `centralcore.command.admin`: /ccの権限

### SetWikiコマンド
- `centralcore.command.setwiki`: /setwikiの権限
  
### Wearコマンド
- `centralcore.command.wear`: /wearの権限

## ライセンス / License
[MIT License](LICENSE)
