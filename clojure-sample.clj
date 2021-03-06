(fn [state time-left]
  (def turn-directions [:right :left :about-face])
  (def smoke-directions [:forward :backward :left :right :drop])

  (let [command-options [(repeat 10 {:action :move
                                     :metadata {}})
                         (repeat 2 {:action :turn
                                    :metadata {:direction (rand-nth turn-directions)}})
                         (repeat 4 {:action :shoot
                                      :metadata {}})
                         (repeat 1 {:action :smoke
                                    :metadata {:direction (rand-nth smoke-directions)}})]]

    (if (= (get-in state [:saved-state :next]) "shoot")
      {:command {:action :shoot :metadata {}}
       :state {:next "turn"}}
      {:command {:action :turn :metadata {:direction :left}}
       :state {:next "shoot"}})))
