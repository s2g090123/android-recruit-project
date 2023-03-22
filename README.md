# Android recruit project - 杜佳謙

## 與原先專案異動項目
1. compileSdk升級為33
2. 將data.json搬移至assets
3. 因data.jsonproposalDueTime日期已過期，因此統一改成2023-06(日期不動)

## 開發環境
1. Mac m2
2. Android Studio 2021.2.1 Patch2
3. 模擬器Android12.0(API 31)
4. Kotlin 1.7.10
5. Gradle 7.0.4

## 技術
1. Jetpack Compose
2. ViewModel
3. Coroutine
4. Coroutine Flow
5. Room
6. Koin
7. Coil
8. Gson
9. DataStore

## 說明
### 資料說明
|     | 顏色  | 標籤  | 狀態  | 是否顯示倒數 |
|  ----  | ----  | ---- | ---- | ---- |
|  INCUBATING | 橘 | 募資中 | 數量 | Y |
| PUBLISHED  | 綠 | 已開課 | 比例 | N |
| SUCCESS | 紅 | 已結束 | 比例 | N |

### 類別架構
[![](https://mermaid.ink/img/pako:eNp9UstOwzAQ_BVrT6lofiDiVEolpJ4IRx-6SpZi1Q9kb4RQ6b8T1yFxiNo9WPbMeGbX8hka1xJU0GgMYavw6NFIK_raYKC9a1DXrvMNicefshRP_X4G39Hu8JSDh-KNAq8O041XMo5paZ_j99QxIEeXCVtkrNn5mf0I3tRF4xGau6b1-lqLqc-JjPWw0-6r3KvA4kic-FCsMoGygfzIROXAXqT9HzIbPU_J3ys2HMPSaRq1uO07jb1ofeOcJrRCWcVRlvHdZ4tMLwNRDMq_FFiDIW9Qtf2vutpK4A8yJKHqty36kwRpow47dvW3baBi39EakvHwCaF6Rx1G9LlVfaNJefkF1ILmxQ?type=png)](https://mermaid.live/edit#pako:eNp9UstOwzAQ_BVrT6lofiDiVEolpJ4IRx-6SpZi1Q9kb4RQ6b8T1yFxiNo9WPbMeGbX8hka1xJU0GgMYavw6NFIK_raYKC9a1DXrvMNicefshRP_X4G39Hu8JSDh-KNAq8O041XMo5paZ_j99QxIEeXCVtkrNn5mf0I3tRF4xGau6b1-lqLqc-JjPWw0-6r3KvA4kic-FCsMoGygfzIROXAXqT9HzIbPU_J3ys2HMPSaRq1uO07jb1ofeOcJrRCWcVRlvHdZ4tMLwNRDMq_FFiDIW9Qtf2vutpK4A8yJKHqty36kwRpow47dvW3baBi39EakvHwCaF6Rx1G9LlVfaNJefkF1ILmxQ)
[![](https://mermaid.ink/img/pako:eNp1ksFuwjAMhl8l8gk0eIFqp63jBNJEp51ywEo8iEibykmHEOPdl5LCsrL55Pz-ov-XkxMopwkKUBa9Lw1uGWvZiFhP6GlNrfMmOD6Kx6_5XDy7jnP1f3KB-0zbTN7Ih-km8Rev8a1TmvX1sLDuMF8aH8SWQvLspck0Y7pWY6A0vA7Osskdxml_efT2S6fQVpFSJOxPP6LWVLtAA8bZ4U_TFZrm3dBhFfdq7xyzMDza4o0pMWAVdRL62mVEaXyLQe2IX9l9Gk0s9J00JIMZ1MQ1Gh1f-BJFQthRTRKK2GrkvQTZ9Bx2wVXHRkERuKMZpPUOHwKKD7T-pr7oPnYiz9_38cIj?type=png)](https://mermaid.live/edit#pako:eNp1ksFuwjAMhl8l8gk0eIFqp63jBNJEp51ywEo8iEibykmHEOPdl5LCsrL55Pz-ov-XkxMopwkKUBa9Lw1uGWvZiFhP6GlNrfMmOD6Kx6_5XDy7jnP1f3KB-0zbTN7Ih-km8Rev8a1TmvX1sLDuMF8aH8SWQvLspck0Y7pWY6A0vA7Osskdxml_efT2S6fQVpFSJOxPP6LWVLtAA8bZ4U_TFZrm3dBhFfdq7xyzMDza4o0pMWAVdRL62mVEaXyLQe2IX9l9Gk0s9J00JIMZ1MQ1Gh1f-BJFQthRTRKK2GrkvQTZ9Bx2wVXHRkERuKMZpPUOHwKKD7T-pr7oPnYiz9_38cIj)
[![](https://mermaid.ink/img/pako:eNp9kcFuwjAMhl-l8gkk2O49TIKWsk7sQrVdMIfQmtGtiaskFULAu89Npx44LEd_X37HzhVKrghi-LKqPUWbLZpIzmKH8JEjmknCumWnDg1NEfbRfP5yQ8gaPj8XXnlCuEXLCcJnTed3SWoQpkPE8s9N2HLnaxPURNQtSWDt2V7-d1NxU-VVISqNatKr0SrkaPZUcGfLR5wJ3nCpmge6CnQtdOEceTeCdQCvMnUlHZ--HRuZdmBZYHnfkVmPV_JQftsNjzwoJ232MANNVqu6kpVeexHBn0gLi6M-3P4goLmLpzrPxcWUEHvb0Qy6VlpTWiv5CQ3xUTVurK6qfl-Def8FWGyEbQ?type=png)](https://mermaid.live/edit#pako:eNp9kcFuwjAMhl-l8gkk2O49TIKWsk7sQrVdMIfQmtGtiaskFULAu89Npx44LEd_X37HzhVKrghi-LKqPUWbLZpIzmKH8JEjmknCumWnDg1NEfbRfP5yQ8gaPj8XXnlCuEXLCcJnTed3SWoQpkPE8s9N2HLnaxPURNQtSWDt2V7-d1NxU-VVISqNatKr0SrkaPZUcGfLR5wJ3nCpmge6CnQtdOEceTeCdQCvMnUlHZ--HRuZdmBZYHnfkVmPV_JQftsNjzwoJ232MANNVqu6kpVeexHBn0gLi6M-3P4goLmLpzrPxcWUEHvb0Qy6VlpTWiv5CQ3xUTVurK6qfl-Def8FWGyEbQ)

### 架構說明
1. 採用的是MVVM + Repository Pattern
2. 採用Dependency Injection與Abstraction Programming注入BaseRepository與BaseDataStore，方便測試與拓展
3. App首次開啟時，取得RemoteData(data.json)轉換成LocalData，並將資料存入Database中
4. UI所需顯示的資料，都是從Database而來(Flow)

### 流程圖
[![](https://mermaid.ink/img/pako:eNqrVkrOT0lVslJKy8kvT85ILCpRCHGJyVMAAsdox4KCWAVdXTsFp-pnM9Y_nbDs5bJpz9YsfDmt--nU-bUQVU4gBTWRNQrOGi_2dj7rn52SWJKol1Wcn6cJUeAMVvB07YynrUtrFFyiXYDySYnFqbHI-v2AMhC-C5jvBnRNjYJrdKhnrJKOUm5qUW5iZgrQldUgRTFKJRmpuakxSlZAZkpiUXaMUkxeLVBdYmlJfnBlXrKSVUlRaaqOUmkB0DGpLpmJ6UWJuUpWaYk5xXBR15TMkvwimMqCxLyo_PxcGDcVLOkLCRlwANUCAE63acQ?type=png)](https://mermaid.live/edit#pako:eNqrVkrOT0lVslJKy8kvT85ILCpRCHGJyVMAAsdox4KCWAVdXTsFp-pnM9Y_nbDs5bJpz9YsfDmt--nU-bUQVU4gBTWRNQrOGi_2dj7rn52SWJKol1Wcn6cJUeAMVvB07YynrUtrFFyiXYDySYnFqbHI-v2AMhC-C5jvBnRNjYJrdKhnrJKOUm5qUW5iZgrQldUgRTFKJRmpuakxSlZAZkpiUXaMUkxeLVBdYmlJfnBlXrKSVUlRaaqOUmkB0DGpLpmJ6UWJuUpWaYk5xXBR15TMkvwimMqCxLyo_PxcGDcVLOkLCRlwANUCAE63acQ)
1. App首次開啟，判定是否初始化過資料，若有執行(3)，否則執行(2)
2. 讀取data.json，取得RemoteData，之後轉換成LocalData，存入Database中
3. 從Database取得LocalData(Flow)
4. 將資料顯示於UI中

## 測試
共寫3個Unit Test和2個Android Test，當中有一個UI Test
- UnitTest
  - CourseRemoteSourceTest
  - CourseRepositoryTest
  - MainViewModelTest
- AndroidTest
  - CourseLocalSourceTest
  - MainScreenTest(UI)
